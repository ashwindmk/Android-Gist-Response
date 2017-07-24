package com.example.ashwin.gisttest;

import android.app.Application;
import android.content.Context;

/**
 * Created by ashwin on 30/6/17.
 */

public class AppController extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
    }

    public static Context getAppContext() {
        return sContext;
    }
}
