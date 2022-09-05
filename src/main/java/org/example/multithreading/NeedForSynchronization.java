package org.example.multithreading;

public class NeedForSynchronization {

    public static void main (String[] args){
        Multithread t = new Multithread();
        t.increment();
        System.out.println(t.getValue());
    }
}

class Multithread{
    private int i = 0;
    public void increment(){
        i++;
    }

    public int getValue(){
        return i;
    }
}
