package com.Version5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

        Priority priority = getPriority();

        tasks.put(++counter, new Task(counter, name, description,dueDate,priority));
        System.out.println("Task Added Successfully !");
    }

    private Priority getPriority() {
        System.out.print("Enter Task Priority (HIGH /MEDIUM/ LOW): ");
        String strPriority = in.next().toUpperCase();
        try{    //might get runtime error
            in.nextLine();
            return Priority.valueOf(strPriority); // convert string -> Priority type using valueOf()
        }catch(IllegalArgumentException e){
            System.out.println("Invalid Priority ! Defaulting to medium...");
            return Priority.MEDIUM;
        }

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
            System.out.printf("Task ID: %-2d | Task Name: %-8s | Task description: %-30s | Task Due Date: %-10s | Task Priority: %-10s\n",
                    task.getKey(),
                    task.getValue().getTaskName(),
                    task.getValue().getTaskDescription(),
                    dateToString(task.getValue().getDueDate()),
                    task.getValue().getPriority()
            );
        }
    }

    private String dateToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dueDate = dateFormat.format(date);
        return dueDate;
    }

    public void viewTasksByPriority() {
        Map<Priority, List<Task>> taskByPriority = new HashMap<>();

        // Adding keys to the hashmap, which is adding Priority first
        for(Priority priority: Priority.values()){
            taskByPriority.put(priority,new ArrayList<>());
        }

        // now add the tasks according to the priority
        for(Task task: tasks.values()){
            taskByPriority.get(task.getPriority()).add(task);
        }

        //CALLING THE FUNCTION WHICH PRINTS TASK BY PRIORITY

        viewTasks("HIGH", taskByPriority.get(Priority.HIGH)); // send the priority and the tasks associated to the respective priority
        viewTasks("MEDIUM", taskByPriority.get(Priority.MEDIUM)); // send the priority and the tasks associated to the respective priority
        viewTasks("LOW", taskByPriority.get(Priority.LOW)); // send the priority and the tasks associated to the respective priority
    }

    //Method overloading to print tasks by priority

    public void viewTasks(String priority, List<Task>tasks) {
        if(!tasks.isEmpty()) {  // do not print if the priority has no tasks
            System.out.println("\n-------- "+priority+" Priority Tasks --------\n");
            for (Task task : tasks) {   // the priority and its associate tasks are sent here, and we traverse them
                System.out.printf("Task ID: %-2d | Task Name: %-8s | Task description: %-30s | Task Due Date: %-10s | Task Priority: %-10s\n",
                        task.getTaskId(),
                        task.getTaskName(),
                        task.getTaskDescription(),
                        dateToString(task.getDueDate()),
                        task.getPriority()
                );
            }
        }
    }

}
