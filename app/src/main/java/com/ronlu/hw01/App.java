package com.ronlu.hw01;


import android.provider.Settings;
import com.ronlu.common.AppCommon;
import com.ronlu.common.utils.MSP;

public class App extends AppCommon {

    @Override
    protected String getDeviceID() {
        return Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    @Override
    protected String getAppPurpose() {
        return COUNTER;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        MSP.initHelper(this);

        statsClass = ActivityStats.class;

    }
}
