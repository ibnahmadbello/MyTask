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

}
