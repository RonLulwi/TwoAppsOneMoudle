package com.ronlu.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class StatsAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<Data> myData;
    private Context context;


    public StatsAdapter(Context context, List<Data> myData) {
        this.myData = myData;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.recycleview_stats_common, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.recycle_LBL_amount.setText(myData.get(position).getAmount());
        holder.recycle_LBL_date.setText(myData.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        if (myData ==null)
            return 0;
        return myData.size();
    }
}
