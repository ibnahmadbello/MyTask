package com.regent.tech.mytask.Database;

import android.provider.BaseColumns;

/**
 * Created by root on 2/10/18.
 */

public final class TaskContract {

    private TaskContract(){}

    static final String CREATE_TASK_ENTRY_TABLE = "CREATE TABLE " + TaskEntry.TABLE_NAME + " ( " +
            TaskEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            TaskEntry.COLUMN_TASK_NAME + " TEXT NOT NULL, " +
            TaskEntry.COLUMN_TASK_DATE + " TEXT NOT NULL, " +
            TaskEntry.COLUMN_TASK_DETAILS + " TEXT NOT NULL, " +
            TaskEntry.COLUMN_TASK_STATUS + " INTEGER NOT NULL, " +
            "UNIQUE (" + TaskEntry._ID + ") ON CONFLICT REPLACE)";

    public static class TaskEntry implements BaseColumns{
        public static final String TABLE_NAME ="task";
        public static final String COLUMN_TASK_NAME = "title";
        public static final String COLUMN_TASK_DETAILS = "details";
        public static final String COLUMN_TASK_DATE = "deadline";
        public static final String COLUMN_TASK_STATUS = "important";

        //The options for the COLUMN_TASK_STATUS
        public static final int IMPORTANT_UNKNOWN = 0;
        public static final int IMPORTANT_YES = 1;
        public static final int IMPORTANT_NO = 2;



    }

}
