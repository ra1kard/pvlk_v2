package org.multithreading.task2;

public class Start {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();

        System.out.println("Main thread started...");
        Thread myThreadX = new Thread(new MyThread(),"MyThreadX");
        Thread myThreadY = new Thread(new MyThread(),"MyThreadY");
        myThreadX.start();
        myThreadY.start();
        System.out.println("Main thread finished...");
    }

}
