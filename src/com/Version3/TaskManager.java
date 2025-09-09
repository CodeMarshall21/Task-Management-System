package com.Version3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

        Date dueDate = null;
        while(dueDate == null){
            dueDate = getDate();
        }

        tasks.put(++counter, new Task(counter, name, description,dueDate));
        System.out.println("Task Added Successfully !");
    }

    private Date getDate(){
        System.out.print("Enter Task Due-Date: ");
        String strDate = in.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try{
            Date dueDate = dateFormat.parse(strDate);
            if(dueDate.before(new Date())){
                System.out.println("Enter the future date !!!");
                return null;
            }
            return dueDate;
        }catch(ParseException e){
            System.out.println("Enter Valid Date Format !! (dd-mm-yyyy)");
        }
        return null;
    }

    public void viewTasks() {
        for(Map.Entry<Integer, Task> task: tasks.entrySet()){
            System.out.printf("Task ID: %-2d | Task Name: %-8s | Task description: %-10s | Task Due Date: %-10s\n",
                    task.getKey(),
                    task.getValue().getTaskName(),
                    task.getValue().getTaskDescription(),
                    dateToString(task.getValue().getDueDate())
            );
        }
    }

    private String dateToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dueDate = dateFormat.format(date);
        return dueDate;
    }
}
