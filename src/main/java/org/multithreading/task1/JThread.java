package org.multithreading.task1;

import java.util.ArrayList;

public class JThread extends Thread {
    private ArrayList<Integer> list;
    enum Operation {FINDMAX, FINDMIN};

    JThread(String name, ArrayList<Integer> list, Operation operation) {
        super(name);
        this.list = list;
        Operation op = operation;
    }

    public void run(ArrayList<Integer> arrayList, boolean findMax, boolean findMin) {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        if (findMax && findMin) {
            findMax(arrayList);
            findMin(arrayList);
        } else if (findMax) {
            findMax(arrayList);
        } else if (findMin) {
            findMin(arrayList);
        }
        System.out.printf("%s fiished... \n", Thread.currentThread().getName());
    }

    public void findMax(ArrayList<Integer> arrayList) {
        System.out.println("Find max: " + arrayList.stream().max(Integer::compareTo).get().intValue());
    }

    public void findMin(ArrayList<Integer> arrayList) {
        System.out.println("Find min: " + arrayList.stream().min(Integer::compareTo).get().intValue());
    }

}
