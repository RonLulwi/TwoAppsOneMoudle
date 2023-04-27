package com.ronlu.common;

import android.app.Application;
import com.ronlu.common.utils.MSP;

public abstract class AppCommon extends Application {

    protected static final String COUNTER = "COUNTER";
    protected static final String GENERAL = "GENERAL";

    public static String deviceID = null;
    public static String AppPurpose = null;

    protected static Class<?> statsClass;


    protected abstract String getDeviceID();
    protected abstract String getAppPurpose();

    @Override
    public void onCreate() {
        super.onCreate();

        MSP.initHelper(this);
        deviceID = getDeviceID();

        AppPurpose = getAppPurpose();

    }
}
