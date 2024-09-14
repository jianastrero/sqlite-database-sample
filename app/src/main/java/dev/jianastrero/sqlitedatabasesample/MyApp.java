package dev.jianastrero.sqlitedatabasesample;

import android.app.Application;

import dev.jianastrero.sqlitedatabasesample.sqlite.helper.AppDbHelper;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AppDbHelper.initialize(this);
    }

}
