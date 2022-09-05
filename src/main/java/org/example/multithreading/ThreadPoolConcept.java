package org.example.multithreading;

import javafx.concurrent.Task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadPool implements Runnable{
    private String name;

    public ThreadPool(String s){
        name = s;
    }

    @Override
    public void run() {
     for (int i=0; i<=5; i++){
         if (i==0) {
             Date d = new Date();
             SimpleDateFormat datetime = new SimpleDateFormat("hh:mm:ss");
             System.out.println("Init time for task name - " + name + " | Time : " + datetime.format(d));
         }
         else {
             Date d = new Date();
             SimpleDateFormat datetime = new SimpleDateFormat(("hh:mm:ss"));
             System.out.println("Executing time for Task name - " + name + " | Time : " + datetime.format(d));
         }
         try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
     }
        System.out.println(name + " Completed");
    }
}

public class ThreadPoolConcept{
    static final int MAX_T = 3;

    public static void main(String[] args){
        //Creates five tasks
        Runnable r1 = new ThreadPool("task 1");
        Runnable r2 = new ThreadPool("task 2");
        Runnable r3 = new ThreadPool("task 3");
        Runnable r4 = new ThreadPool("task 4");
        Runnable r5 = new ThreadPool("task 5");

        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);
        pool.execute(r5);

        pool.shutdown();
    }
}
