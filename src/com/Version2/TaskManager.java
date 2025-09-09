package com.Version2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskManager {

    Scanner in = new Scanner(System.in);
    private Map<Integer, Task> tasks = new HashMap<>();
    int counter = 0;

    public void addTask() {
        System.out.print("Enter Task Name: ");
        String name = in.nextLine();

        System.out.print("Enter Task Description: ");
        String description = in.nextLine();

        tasks.put(++counter, new Task(counter, name, description));
        System.out.println("Task Added Successfully !");
    }

    public void viewTasks() {
        for(Map.Entry<Integer, Task> task: tasks.entrySet()){
            System.out.printf("Task ID: %-2d | Task Name: %-8s | Task description: %-10s\n",
                    task.getKey(),
                    task.getValue().getTaskName(),
                    task.getValue().getTaskDescription()
            );
        }
    }
}
