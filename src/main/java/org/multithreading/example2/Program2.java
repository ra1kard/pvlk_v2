package org.multithreading.example2;

public class Program2 {

    public static void main(String[] args) {
        System.out.println("Main thread started...");
        for(int i=1; i < 6; i++)
            new JThread("JThread " + i).start();
        System.out.println("Main thread finished...");
    }

}
