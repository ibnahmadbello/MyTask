package com.regent.tech.mytask.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by root on 2/11/18.
 */

public class DatabaseSQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "task.db";
    private static final int VERSION_NUMBER = 1;

    //Constructor
    public DatabaseSQLiteOpenHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TaskContract.CREATE_TASK_ENTRY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + TaskContract.TaskEntry.TABLE_NAME);

        onCreate(db);
    }
}
