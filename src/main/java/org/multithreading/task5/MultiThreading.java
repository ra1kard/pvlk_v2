package org.multithreading.task5;

public class MultiThreading extends Thread {
    public static int counter = 22;
    private static String name;
    private int number;

    public MultiThreading(String name, int number) {
        this.name = name;
        this.number = number;
    }

}
