package com.regent.tech.mytask.model;

/**
 * Created by root on 2/11/18.
 */

public class Task {

    private String name;
    private String date;
    private int stateOfTask;
    private String details;

    public Task(String name, String details, String date, int stateOfTask){
        this.name = name;
        this.details = details;
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

    public int getStateOfTask() {
        return stateOfTask;
    }

    public void setStateOfTask(int stateOfTask) {
        this.stateOfTask = stateOfTask;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
