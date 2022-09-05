package org.example.multithreading;

class MultithreadingDemo extends Thread{
    public void run(){
        try {
            System.out.println(
                    "Thread " + Thread.currentThread().getId()
                            + " is running");

//            System.out.println(Thread.getAllStackTraces());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
        }


//main method
public class MultithreadingByExtendThread {
    public static void main(String[] args)
    {
        int n = 6; // Number of threads
        for (int i = 0; i < n; i++) {
            MultithreadingDemo object
                    = new MultithreadingDemo();
            object.start();
        }
    }
}


