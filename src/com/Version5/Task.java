package com.Version5;

import java.util.Date;
import java.util.Set;

public class Task {
    private final int taskId;
    private String taskName;
    private String taskDescription;
    private Date dueDate;
    private Priority priority;
    private Set<String> categories;

    public Task(int id, String task, String description, Date date, Priority priority, Set<String> categories){
        this.taskId = id;
        this.taskName = task;
        this.taskDescription = description;
        dueDate = date;
        this.priority = priority;
        this.categories = categories;
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

    public Set<String> getCategories() {
        return categories;
    }
}
