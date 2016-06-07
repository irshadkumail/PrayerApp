package com.sodo.kumail.prayerapp;

import android.app.Application;

/**
 * Created by kumail on 6/5/2016.
 */

public class MyApplication extends Application {

    static MyApplication myApplication;

    public void onCreate()
    {
        super.onCreate();
        myApplication=this;

    }

    public static MyApplication getMyApplication()
    {
        return myApplication;
    }

}
