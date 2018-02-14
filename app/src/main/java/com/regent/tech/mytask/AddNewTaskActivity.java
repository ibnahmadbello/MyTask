package com.regent.tech.mytask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

public class AddNewTaskActivity extends AppCompatActivity {

    private static final String TAG = AddNewTaskActivity.class.getSimpleName();

    private EditText mTitleofTask;
    private EditText mDetailofTask;
    private DatePicker mDeadlineofTask;
    private Spinner mStateofTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_task);

        mTitleofTask = (EditText) findViewById(R.id.write_your_title_here);
        mDetailofTask = (EditText) findViewById(R.id.type_your_details_here);
        mDeadlineofTask = (DatePicker) findViewById(R.id.date_of_your_task);
        mStateofTask = (Spinner) findViewById(R.id.spinner_yes_or_no);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_add_task, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){


        return super.onOptionsItemSelected(menuItem);
    }
}
