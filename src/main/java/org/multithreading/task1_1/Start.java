package org.multithreading.task1_1;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String args[]) {
        ArrayList<Integer> listOne = new ArrayList<>(List.of(100, 200, -5, -44, 663, 7));
        ArrayList<Integer> listTwo = new ArrayList<>(List.of(1, 20, -5, -44, 66, 7));

        System.out.println("Main thread started...");

        SearchThread threadMax = new SearchThread("ThreadMax", listOne, SearchThread.Operation.FINDMAX);
        SearchThread threadMin = new SearchThread("ThreadMin", listTwo, SearchThread.Operation.FINDMIN);

        threadMax.start();
        threadMin.start();

        try {
            threadMax.join();
            threadMin.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished...");
    }
}
