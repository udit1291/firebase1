package com.example.internship;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    TextView fire1,fire2,fire3,rate,payment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final String message = getIntent().getStringExtra("messa");

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();


        fire1=(TextView) findViewById(R.id.firetext1);
        fire2=(TextView) findViewById(R.id.firetext2);
        fire3=(TextView) findViewById(R.id.firetext3);
        rate=(TextView)findViewById(R.id.rate1);
        payment=(TextView)findViewById(R.id.payment1);


        try{
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                        fire1.setText((String) dataSnapshot.child(message).child("occupation").getValue());
                        fire2.setText((String) dataSnapshot.child(message).child("date").getValue()+" "+(String) dataSnapshot.child(message).child("time").getValue());
                        fire3.setText((String) dataSnapshot.child(message).child("address").getValue());
                        rate.setText((String) dataSnapshot.child(message).child("rate").getValue());
                        payment.setText((String) dataSnapshot.child(message).child("payment").getValue());

            }

            @Override
            public void onCancelled(DatabaseError error) {

                Toast.makeText(Main2Activity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });}catch (Exception e){        Toast.makeText(Main2Activity.this, e.toString(), Toast.LENGTH_SHORT).show(); }
    }
}
