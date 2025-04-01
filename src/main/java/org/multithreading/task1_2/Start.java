package org.multithreading.task1_2;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        ArrayList<Integer> listOne = new ArrayList<>(List.of(-100, 200, -5, -44, 663, 7));
        ArrayList<Integer> listTwo = new ArrayList<>(List.of(1, 20, -5, -44, 66, 7));

        System.out.println("Main thread started...");

        SearchThread threadMax = new SearchThread("TThreadMax", listOne, FindNumber.FINDMAX);
        SearchThread threadMin = new SearchThread("TThreadMin", listTwo, FindNumber.FINDMIN);

        threadMax.start();
        threadMin.start();

        try {
            threadMin.join();
            System.out.println("Min closed");
            threadMax.join();
            System.out.println("Max closed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished...");
    }

}
