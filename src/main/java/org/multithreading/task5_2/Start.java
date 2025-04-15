package org.multithreading.task5_2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Start {

    public static void main(String[] args) {
        System.out.println("Main thread started….");
        List<MultiThreading> multiThreadingList = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(3);     //пул из 3 потоков

        for (int i = 0; i < 2; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task + " + taskId + " is running on thread " + Thread.currentThread().getName());
            });

            /*MultiThreading thread = new MultiThreading("thread" + (i+1), i+1);
            multiThreadingList.add(thread);
            thread.start();*/
        }

        System.out.println("Main thread finished...");
    }

}
