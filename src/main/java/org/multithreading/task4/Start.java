package org.multithreading.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Start {

    public static void main(String[] args) {
        System.out.println("Main thread started….");
        List<MultiThreading> multiThreadingList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int sleepTime = 0;
            try {
                sleepTime = 1000 + random.nextInt(2000); // Генерируем случайное время от 1 до 3 секунд
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MultiThreading thread = new MultiThreading("thread" + (i+1) + "_" + sleepTime, i+1);
            multiThreadingList.add(thread);
            thread.start();
        }

        System.out.println("- - - - - multiThreadingList: - - - - -");
        for (MultiThreading multiThreading : multiThreadingList) {
            System.out.println(multiThreading.getName() + " № присвоенный при создании: " + multiThreading.getNumber());
        }
        System.out.println();

        System.out.println("Main thread finished...");
    }

}
