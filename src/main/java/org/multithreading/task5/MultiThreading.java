package org.multithreading.task5;

public class MultiThreading extends Thread {
    public static int counter = 22;
    private static String name;
    private int number;

    public MultiThreading(String name, int number) {
        super(name);
        this.number = number;
    }

    @Override
    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());

        while (true) {
            if (counter <= 149600) {
                try {
                    Thread.sleep(0,1);
                    counter++;
                    System.out.println(Thread.currentThread().getName() + " counter: " + counter);
                } catch (InterruptedException e) {
                    System.out.println("Thread has been interrupted");
                }
            } else {
                break;
            }
        }

        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }

}
