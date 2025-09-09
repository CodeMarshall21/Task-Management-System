package com.Version3;

import java.util.Date;

public class Task {
    private final int taskId;
    private String taskName;
    private String taskDescription;
    private Date dueDate;

    public Task(int id, String task, String description, Date date){
        this.taskId = id;
        this.taskName = task;
        this.taskDescription = description;
        dueDate = date;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription(){
        return taskDescription;
    }

    public Date getDueDate() {
        return dueDate;
    }
}
