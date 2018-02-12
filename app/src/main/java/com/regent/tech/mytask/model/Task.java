package com.regent.tech.mytask.model;

/**
 * Created by root on 2/11/18.
 */

public class Task {

    private String name;
    private String date;
    private String stateOfTask;

    public Task(String name, String date, String stateOfTask){
        this.name = name;
        this.date = date;
        this.stateOfTask = stateOfTask;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStateOfTask() {
        return stateOfTask;
    }

    public void setStateOfTask(String stateOfTask) {
        this.stateOfTask = stateOfTask;
    }

}
