package com.regent.tech.mytask.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.regent.tech.mytask.model.Task;

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

    public void insertTask(Task task){
        ContentValues values = new ContentValues();
        values.put(TaskContract.TaskEntry.COLUMN_TASK_NAME, task.getName());
        values.put(TaskContract.TaskEntry.COLUMN_TASK_DATE, task.getDate());
        values.put(TaskContract.TaskEntry.COLUMN_TASK_DETAILS, task.getDetails());
        values.put(TaskContract.TaskEntry.COLUMN_TASK_STATUS, task.getStateOfTask());

        long rowID = database.insert(TaskContract.TaskEntry.TABLE_NAME, null, values);

        Log.d(TAG, "Task with id: " + rowID);
    }

}
