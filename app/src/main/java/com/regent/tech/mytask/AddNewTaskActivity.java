package com.regent.tech.mytask;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.regent.tech.mytask.Database.DatabaseSQLiteOpenHelper;
import com.regent.tech.mytask.Database.TaskContract;

public class AddNewTaskActivity extends AppCompatActivity {

    private static final String TAG = AddNewTaskActivity.class.getSimpleName();

    private EditText mTitleofTask;
    private EditText mDetailofTask;
    private EditText mDeadlineofTask;
    private Spinner mStateofTask;


    public int mTask = TaskContract.TaskEntry.IMPORTANT_UNKNOWN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_task);

        mTitleofTask = (EditText) findViewById(R.id.write_your_title_here);
        mDetailofTask = (EditText) findViewById(R.id.type_your_details_here);
        mDeadlineofTask = (EditText) findViewById(R.id.date_of_your_task);
        mStateofTask = (Spinner) findViewById(R.id.spinner_yes_or_no);

        setupSpinner();

    }

    private void setupSpinner(){
        //Create the Adapter for the Spinner
        ArrayAdapter stateOfTaskAdapter = ArrayAdapter.createFromResource(this, R.array.task_important,
                android.R.layout.simple_spinner_item);

        //Specify the dropdown layout style
        stateOfTaskAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        //Attached the adapter to the Spinner
        mStateofTask.setAdapter(stateOfTaskAdapter);

        //Set the integer selected to a constant value
        mStateofTask.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)){
                    if (selection.equals(getString(R.string.important_yes))){
                        mTask = TaskContract.TaskEntry.IMPORTANT_YES;
                    }
                    else if (selection.equals(getString(R.string.important_no))){
                        mTask = TaskContract.TaskEntry.IMPORTANT_NO;
                    }
                    else {
                        mTask = TaskContract.TaskEntry.IMPORTANT_UNKNOWN;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mTask = TaskContract.TaskEntry.IMPORTANT_UNKNOWN;
            }
        });
    }

    private void insertTask(){
        String nameOfTask = mTitleofTask.getText().toString().trim();
        String detailOfTask = mDetailofTask.getText().toString().trim();
        String dateOfTask = mDeadlineofTask.getText().toString().trim();

        //Create a database helper
        DatabaseSQLiteOpenHelper helper = new DatabaseSQLiteOpenHelper(this);

        //Get the database in write mode
        SQLiteDatabase db = helper.getWritableDatabase();

        //ContentValues to insert task to the db
        ContentValues values = new ContentValues();
        values.put(TaskContract.TaskEntry.COLUMN_TASK_NAME, nameOfTask);
        values.put(TaskContract.TaskEntry.COLUMN_TASK_DETAILS, detailOfTask);
        values.put(TaskContract.TaskEntry.COLUMN_TASK_DATE, dateOfTask);
        values.put(TaskContract.TaskEntry.COLUMN_TASK_STATUS, mTask);

        //Insert a new row
        long newRowId = db.insert(TaskContract.TaskEntry.TABLE_NAME, null, values);

        //Show a toast depending on if the row insert was successful or not
        if (newRowId == -1){
            //This toast display if there is an error while inserting a new task
            Toast.makeText(this, "Error inserting a task", Toast.LENGTH_SHORT).show();
        }
        else {
            //This toast display if there is a successful insertion of a new task
            Toast.makeText(this, "Successfully inserted a new task", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_add_task, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){

        switch (menuItem.getItemId()){
            case R.id.save_action:
                //Make a call to the insert database method
                insertTask();

                finish(); //Finish Activity
                return true;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }

        return super.onOptionsItemSelected(menuItem);
    }
}
