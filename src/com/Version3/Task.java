package com.Version3;

public class Task {
    private final int taskId;
    private String taskName;
    private String taskDescription;

    public Task(int id, String task, String description){
        this.taskId = id;
        this.taskName = task;
        this.taskDescription = description;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription(){
        return taskDescription;
    }
}
