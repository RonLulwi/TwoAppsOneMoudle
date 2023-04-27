package com.ronlu.hw01;


import com.google.gson.reflect.TypeToken;
import com.ronlu.common.ActivityStatsCommon;
import com.ronlu.common.Data;
import com.ronlu.common.utils.MSP;

import java.util.ArrayList;
import java.util.List;

public class ActivityStats extends ActivityStatsCommon {


    @Override
    protected List<Data> getAppData(List<Data> newData) {
        ArrayList<Data> data = MSP.getInstance().getArray("SP_DATA", new TypeToken<ArrayList<Data>>() {});
        if(data == null)
            data = new ArrayList<>();
        if(newData != null && !newData.isEmpty())
            data.addAll(newData);
        MSP.getInstance().putArray("SP_DATA", data);
        return data;
    }

    @Override
    protected String getAppBalance(List<Data> data) {
        double balance = 0.0;
        for (int i = 0; i < data.size(); i++) {
            balance += Double.parseDouble(data.get(i).getAmount());
        }
        return "Total spent balance " +balance;
    }
}