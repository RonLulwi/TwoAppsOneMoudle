package com.ronlu.common;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView recycle_LBL_amount, recycle_LBL_date;

    public MyViewHolder(@NonNull View view) {
        super(view);
        recycle_LBL_amount = view.findViewById(R.id.recycle_LBL_amount);
        recycle_LBL_date = view.findViewById(R.id.recycle_LBL_date);


    }
}
