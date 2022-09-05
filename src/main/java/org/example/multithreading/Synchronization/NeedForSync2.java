package org.example.multithreading.Synchronization;

public class NeedForSync2 {

    public static void main(String[] args) {
        Line obj = new Line();
        Train train1 = new Train(obj, "train1");
        Train train2 = new Train(obj, "train2");
        train1.start();
        train2.start();
    }
}

class Line{

    //Use Synchronized keyword to avoid collision
    synchronized public void getLine(String thread){
        for(int i =0; i <3 ; i++){
            System.out.println(i + " | Thread : " + thread);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println(e);
                throw new RuntimeException(e);
            }
        }
    }
}

class Train extends Thread
{
    //Reference to Line object
    Line line;
    String thread;
    Train(Line line, String a){
        this.line = line;
        this.thread = a;
    }

    public void run(){
        line.getLine(thread);
    }
}
