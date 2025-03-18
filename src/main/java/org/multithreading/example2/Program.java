package org.multithreading.example2;

public class Program {

    public static void main(String[] args) {
        System.out.println("Main thread started...");
        new JThread("JThread").start();
        System.out.println("Main thread finished...");
    }

}
