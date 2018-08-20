package com.example.internship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MyOrders extends AppCompatActivity {
    private List<orders> orderList = new ArrayList<>();
    private RecyclerView recyclerView;
    private adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new adapter(orderList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));




        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot uniqueKeySnapshot : dataSnapshot.getChildren()){
                    String value = uniqueKeySnapshot.getKey();
                    String head2= (String) uniqueKeySnapshot.child("date").getValue();
                    String head3= (String) uniqueKeySnapshot.child("time").getValue();
                    String head4= (String) uniqueKeySnapshot.child("occupation").getValue();

                    orders order = new orders(value, head3, head4,head2);
                    orderList.add(order);
                }
                mAdapter.notifyDataSetChanged();


                }

            @Override
            public void onCancelled(DatabaseError error) {

                Toast.makeText(MyOrders.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });


        recyclerView.addOnItemTouchListener(new recycletouch(getApplicationContext(), recyclerView, new recycletouch.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                orders order = orderList.get(position);
                Toast.makeText(getApplicationContext(),  order.gethead1()+" is selected!", Toast.LENGTH_SHORT).show();
                Intent int1 = new Intent(MyOrders.this,Main2Activity.class);
                int1.putExtra("messa", order.gethead1());
                startActivity(int1);

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


    }


}