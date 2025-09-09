package com.Version1;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class TaskManager {

    Scanner in = new Scanner(System.in);
    private Map<Integer, Task> tasks = new HashMap<>();
    int counter = 0;

    public void addTask() {
        System.out.print("Enter Task Name: ");
        String name = in.nextLine();
        tasks.put(++counter, new Task(counter, name));
        System.out.println("Task Added Successfully !");
    }

    public void viewTasks() {
        for(Map.Entry<Integer, Task> task: tasks.entrySet()){
            System.out.printf("Task ID: %-2d | Task Name: %-8s\n",
                    task.getKey(),
                    task.getValue().getTaskName()
            );
        }
    }
}
