package dev.jianastrero.sqlitedatabasesample;

import android.app.Application;

import net.zetetic.database.sqlcipher.SQLiteDatabase;

import dev.jianastrero.sqlitedatabasesample.sqlite.helper.AppDbHelper;

public class MyApp extends Application {

    static {
        System.loadLibrary("sqlcipher");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        AppDbHelper.initialize(this);
    }

}
