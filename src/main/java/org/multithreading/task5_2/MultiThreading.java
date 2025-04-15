package org.multithreading.task5_2;

public class MultiThreading extends Thread {
    public static int counterX = 22;
    public static int counterY = 22;
    private static String name;
    private int number;

    public MultiThreading(String name, int number) {
        super(name);
        this.number = number;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.printf("%s started... \n", threadName);

        while (true) {
            if (threadName.equalsIgnoreCase("thread1")) {
                if (counterX <= 149600) {
                    try {
                        Thread.sleep(0,0000000001);
                        counterX++;
                        System.out.println(Thread.currentThread().getName() + " counterX: " + counterX);
                    } catch (InterruptedException e) {
                        System.out.println("Thread has been interrupted");
                    }
                } else {
                    break;
                }
            } else if (threadName.equalsIgnoreCase("thread2")) {
                if (counterY <= 99600) {
                    try {
                        Thread.sleep(0,0000000001);
                        counterY++;
                        System.out.println(Thread.currentThread().getName() + " counterY: " + counterY);
                    } catch (InterruptedException e) {
                        System.out.println("Thread has been interrupted");
                    }
                } else {
                    break;
                }
            }

        }

        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }

}
