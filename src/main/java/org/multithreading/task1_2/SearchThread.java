package org.multithreading.task1_2;

import java.util.ArrayList;

public class SearchThread extends Thread {
    public FindNumber findNumber;
    private final ArrayList<Integer> list;
    private int result;

    public SearchThread(String name, ArrayList<Integer> list, FindNumber findNumber) {
        super(name);
        this.list = list;
        this.findNumber = findNumber;
    }

    @Override
    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }
        if (findNumber.equals(FindNumber.FINDMAX)) {
            result = list.stream().max(Integer::compareTo).get();
            System.out.println("Find max: " + result);
        } else {
            result = list.stream().min(Integer::compareTo).get();
            System.out.println("Find min: " + result);
        }
    }

}
