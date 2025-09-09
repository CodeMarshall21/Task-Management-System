package com.Version1;

public class Task {
    private final int taskId;
    private String taskName;

    public Task(int id, String task){
        this.taskId = id;
        this.taskName = task;
    }

    public String getTaskName() {
        return taskName;
    }
}
