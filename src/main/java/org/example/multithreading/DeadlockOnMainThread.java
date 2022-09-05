package org.example.multithreading;

public class DeadlockOnMainThread {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Entering into Deadlock");

        Thread.currentThread().join();

        System.out.println("This will never execute");

    }
}
