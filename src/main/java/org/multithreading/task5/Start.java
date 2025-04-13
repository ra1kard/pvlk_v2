package org.multithreading.task5;

import org.multithreading.task4.MultiThreading;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        System.out.println("Main thread started….");
        List<MultiThreading> multiThreadingList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int sleepTime = 0;
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MultiThreading thread = new MultiThreading("thread" + (i+1) + "_" + sleepTime, i+1);
            multiThreadingList.add(thread);
            thread.start();
        }

        System.out.println("Main thread finished...");
    }

}
