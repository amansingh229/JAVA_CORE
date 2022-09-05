package org.example;

public class MainThreadInJava extends Thread {

    //Main Driver mentod
    public static void main(String[] args){
        //Getting Reference to the main thread
        Thread t = Thread.currentThread();
        System.out.println("Get Name of the Current Thread : " + t.getName());

        t.setName("MainThread");
        System.out.println("Modified name of the Current Thread : " + t.getName());
        System.out.println("======================================");

        System.out.println("Priority of the main thread : " + t.getPriority());

        t.setPriority(MAX_PRIORITY);
        System.out.println("Priority of the main thread after change : " + t.getPriority());

        System.out.println("======================================");

        for( int i = 0; i<5; i++){
            System.out.println("Main Thread");
        }

        System.out.println("======================================");

        //Main thread creating a child thread

        Thread childThread = new Thread(){
            //run method of a thread
            public void run(){
                for(int i = 0; i <5 ; i++){
                    System.out.println("Child Thread");
                }
            }
        };

        childThread.start();
        System.out.println("Child Thread Priority " + childThread.getPriority());

        System.out.println("======================================");

        childThread.setPriority(MIN_PRIORITY);
        System.out.println("Child Thread Priority after change " + childThread.getPriority());
        System.out.println("======================================");

    }
}
