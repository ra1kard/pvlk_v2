package org.multithreading.task4;

import java.util.Random;

public class MultiThreading extends CounterThread {
    public static int counter = 22;
    private int number;

    public MultiThreading(String name, int number) {
        super(name);
        this.number = number;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        MultiThreading.counter = counter;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        Random random = new Random();
        String threadName = Thread.currentThread().getName();
        System.out.printf("%s started... \n", threadName);

        while (true) {

            if (counter < 42) {
                try {
                    int sleepTime = 1000 + random.nextInt(2000);
                    Thread.sleep(500);
                    counter++;
                    System.out.println("= Counter: " + counter + " Thread: " + threadName);
                } catch (InterruptedException e) {
                    System.out.println("Thread has been interrupted");
                }
            } else {
                break;
            }

        }

        System.out.printf("%s finished... \n", threadName);
    }

}
//TODO - интересно, то есть за счет того, что у нас несколько потоков, мы не смогли вовремя остановиться?
//TODO - условно для некоторых потоков у меня счетчик был буд-то меньше 42, поэтому выполнялась операция?
