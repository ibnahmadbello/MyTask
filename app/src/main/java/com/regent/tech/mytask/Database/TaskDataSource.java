package com.regent.tech.mytask.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by root on 2/12/18.
 */

public class TaskDataSource {

    private static final String TAG =TaskDataSource.class.getSimpleName();

    private SQLiteDatabase database;
    private DatabaseSQLiteOpenHelper sqLiteOpenHelper;

    public TaskDataSource(Context context){
        this.sqLiteOpenHelper = new DatabaseSQLiteOpenHelper(context);
    }

    public void open(){
        this.database = sqLiteOpenHelper.getWritableDatabase();

        Log.d(TAG, "Database is opened");
    }

    public void close(){
        sqLiteOpenHelper.close();

        Log.d(TAG, "Database is closed");
    }

}
