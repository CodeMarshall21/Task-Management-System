package com.Version1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        Scanner in = new Scanner(System.in);
        System.out.println("Welcome");
        boolean isRunning = true;
        while(isRunning){
            System.out.println("\n1. Add Task \n2. View Task \n3. Exit");
            System.out.print("Enter Choice: ");
            int choice = in.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Adding Task...");
                    taskManager.addTask();
                    break;
                case 2:
                    System.out.println("Displaying all Tasks...");
                    taskManager.viewTasks();
                    break;
                case 3:
                    System.out.println("Exited... See you soon !");
                    isRunning = false;
            }
        }
        in.close();
    }
}
