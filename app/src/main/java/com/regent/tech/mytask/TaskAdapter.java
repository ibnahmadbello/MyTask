package com.regent.tech.mytask;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.regent.tech.mytask.model.Task;

import java.util.List;

/**
 * Created by root on 2/11/18.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder>{

    private Context mContext;
    private List<Task> taskList;
    private static final String TAG = TaskAdapter.class.getSimpleName();

    public TaskAdapter(Context context){
        this.mContext = context;
    }

    void setTaskList(List<Task> tasks){
        this.taskList = tasks;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView taskName;
        TextView taskDate;
        TextView taskState;

        public ViewHolder(View view){
            super(view);

            taskName = (TextView) view.findViewById(R.id.task);
            taskDate = (TextView) view.findViewById(R.id.date);
            taskState = (TextView) view.findViewById(R.id.state_of_task);
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.each_row_task, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        //TODO: Need to bind the various views
        Task task = taskList.get(position);

        holder.taskName.setText(task.getName());
        holder.taskDate.setText(task.getDate());
        holder.taskState.setText(task.getStateOfTask());
    }

    @Override
    public int getItemCount(){
        //TODO: Need to return the size of the task
        return this.taskList.size();
    }

}
