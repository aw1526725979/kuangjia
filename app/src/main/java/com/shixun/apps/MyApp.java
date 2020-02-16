package com.shixun.apps;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;


public class MyApp extends Application {

    public static Application app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
