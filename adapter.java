package com.example.internship;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.MyViewHolder> {

    private List<orders> ordersList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView head1, head2,head3, righthead;

        public MyViewHolder(View view) {
            super(view);
            head1 = (TextView) view.findViewById(R.id.head1);
            head2 = (TextView) view.findViewById(R.id.head2);
            head3= (TextView) view.findViewById(R.id.head3);
            righthead= (TextView) view.findViewById(R.id.righthead);
        }
    }


    public adapter(List<orders> ordersList) {
        this.ordersList = ordersList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.orderslist, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        orders movie = ordersList.get(position);
        holder.head1.setText(movie.gethead1());
        holder.head2.setText(movie.gethead2());
        holder.head3.setText(movie.gethead3());
        holder.righthead.setText(movie.getrighthead());
    }

    @Override
    public int getItemCount() {
        return ordersList.size();
    }
}