package com.regent.tech.mytask.Database;

import android.provider.BaseColumns;

/**
 * Created by root on 2/10/18.
 */

public final class TaskContract {

    private TaskContract(){}

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
