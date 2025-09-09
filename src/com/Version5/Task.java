package com.Version5;

import java.util.Date;

public class Task {
    private final int taskId;
    private String taskName;
    private String taskDescription;
    private Date dueDate;
    private Priority priority;

    public Task(int id, String task, String description, Date date, Priority priority){
        this.taskId = id;
        this.taskName = task;
        this.taskDescription = description;
        dueDate = date;
        this.priority = priority;
    }

    public int getTaskId(){
        return taskId;
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

    public Priority getPriority(){
        return priority;
    }
}
