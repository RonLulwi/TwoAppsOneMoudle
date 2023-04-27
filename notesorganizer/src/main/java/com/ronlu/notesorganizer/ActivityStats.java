package com.ronlu.notesorganizer;



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
        return "You have " + data.size() + " notes" ;
    }
}