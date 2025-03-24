package org.multithreading.task2;

public class MyThread implements Runnable {
    public static int counter = 5000;
    public void increment() {
        counter++;
    }
    public void decrement() {
        counter--;
    }

    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());

        try{
            Thread.sleep(1500);
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }

        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }

}
