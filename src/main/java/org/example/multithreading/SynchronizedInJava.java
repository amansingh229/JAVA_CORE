package org.example.multithreading;

public class SynchronizedInJava {
    public void send(String msg) {
        System.out.println("Send Message 1: " + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread got interrupted");
            throw new RuntimeException(e);
        }
        System.out.println("Sent 1: " + msg);
    }
}

class Threadedsend extends Thread{
    private String msg;
    SynchronizedInJava sender;

    Threadedsend(String m,SynchronizedInJava obj){
        msg = m;
        sender = obj;
    }

    public void run(){
        synchronized (sender){
            sender.send(msg);
        }
    }
}

//Driver Class

class SyncDemo{
    public static void main(String args[]){
        SynchronizedInJava send = new SynchronizedInJava();
        Threadedsend s1 = new Threadedsend( "Hi" , send);
        Threadedsend s2 = new Threadedsend("Bye", send);

        s1.start();
        s2.start();

        //wait for threads to end

        try {
            s1.join();
            s2.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
            throw new RuntimeException(e);
        }



    }
}