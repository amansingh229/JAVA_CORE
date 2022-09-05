package org.example.multithreading;

class MultithreadingDemoByRunnable implements Runnable{
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
class MultithreadingByRunnable {
    public static void main(String[] args)
    {
        int n = 6; // Number of threads
        for (int i = 0; i < n; i++) {
            Thread object
                    = new Thread( new MultithreadingDemoByRunnable());
            object.start();
        }
    }
}


