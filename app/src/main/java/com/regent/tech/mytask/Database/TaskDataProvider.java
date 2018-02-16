package com.regent.tech.mytask.Database;

import com.regent.tech.mytask.model.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 2/13/18.
 */

public class TaskDataProvider {

    public static List<Task> taskList;

    static {
        taskList = new ArrayList<>();

        addTask(new Task("Scholarship", "Try to apply for Saudi Arabia Scholarship", "01/01/1970",
                1));
        addTask(new Task("Browsing", "Browse into Nairaland and see what is happening", "02/02/1970",
                1));
        addTask(new Task("Update", "Going to BUK to find out about the admission stuff", "03/03/1970",
                1));
    }

    private static void addTask(Task task){
        taskList.add(task);
    }

}
