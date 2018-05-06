package com.regent.tech.mytask;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.regent.tech.mytask.Database.DatabaseSQLiteOpenHelper;
import com.regent.tech.mytask.Database.TaskContract;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting the FAB to link with the AddNewTaskActivity
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddNewTaskActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    protected void onResume(){
        super.onResume();
        displayTask();
    }

    private void displayTask(){
        //Create a database helper
        DatabaseSQLiteOpenHelper helper = new DatabaseSQLiteOpenHelper(this);

        //Get the database in read mode
        SQLiteDatabase db = helper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                TaskContract.TaskEntry._ID,
                TaskContract.TaskEntry.COLUMN_TASK_NAME,
                TaskContract.TaskEntry.COLUMN_TASK_DETAILS,
                TaskContract.TaskEntry.COLUMN_TASK_DATE,
                TaskContract.TaskEntry.COLUMN_TASK_STATUS };

        // Perform a query on the pets table
        Cursor cursor = db.query(
                TaskContract.TaskEntry.TABLE_NAME, // The table to query
                projection,            // The columns to return
                null,                  // The columns for the WHERE clause
                null,                  // The values for the WHERE clause
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                null);                   // The sort order

        TextView displayTask = (TextView) findViewById(R.id.task_view);

        try {
            displayTask.setText("You have " + cursor.getCount() + "number of task undone.\n\n\n");

            displayTask.append(TaskContract.TaskEntry._ID + "\t" +
                    TaskContract.TaskEntry.COLUMN_TASK_NAME + "\t" +
                    TaskContract.TaskEntry.COLUMN_TASK_DETAILS + "\t" +
                    TaskContract.TaskEntry.COLUMN_TASK_DATE + "\t" +
                    TaskContract.TaskEntry.COLUMN_TASK_STATUS + "\n\n");

            // Figure out the index of each column
            int idColumnIndex = cursor.getColumnIndex(TaskContract.TaskEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(TaskContract.TaskEntry.COLUMN_TASK_NAME);
            int detailColumnIndex = cursor.getColumnIndex(TaskContract.TaskEntry.COLUMN_TASK_DETAILS);
            int dateColumnIndex = cursor.getColumnIndex(TaskContract.TaskEntry.COLUMN_TASK_DATE);
            int statusColumnIndex = cursor.getColumnIndex(TaskContract.TaskEntry.COLUMN_TASK_STATUS);

            // Iterate through all the returned rows in the cursor
            while (cursor.moveToNext()) {
                // Use that index to extract the String or Int value of the word
                // at the current row the cursor is on.
                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                String currentDetail = cursor.getString(detailColumnIndex);
                String currentDate = cursor.getString(dateColumnIndex);
                int currentStatus = cursor.getInt(statusColumnIndex);
                // Display the values from each column of the current row in the cursor in the TextView
                displayTask.append(("\n" + currentID + "\t" +
                        currentName + "\t" +
                        currentDetail + "\t" +
                        currentDate + "\t" +
                        currentStatus));
            }
        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }


    }

}
