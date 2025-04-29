package org.multithreading.task5_3;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        System.out.println("Main thread started….");
        List<MultiThreading> multiThreadingList = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            MultiThreading thread = new MultiThreading("thread" + (i+1), i+1);
            multiThreadingList.add(thread);
            thread.start();
        }

        System.out.println("Main thread finished...");
    }

}
