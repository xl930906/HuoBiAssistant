package com.android.HuoBiAssistant.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dragon丶Lz on 2016/4/6.
 */
public class AppDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_DATA = "create table HuobiData";


    public AppDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
