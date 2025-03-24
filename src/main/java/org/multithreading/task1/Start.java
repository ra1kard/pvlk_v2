package org.multithreading.task1;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        ArrayList<Integer> listOne = new ArrayList<>(List.of(100, 200, -5, -44, 663, 7));
        ArrayList<Integer> listTwo = new ArrayList<>(List.of(1, 20, -5, -44, 66, 7));

        System.out.println("Main thread started...");


        JThread jThread_one = new JThread("JThread_One", listOne, JThread.Operation.FINDMAX);
        jThread_one.start();
        try{
            jThread_one.join();
        }
        catch(InterruptedException e){
            System.out.printf("%s has been interrupted", jThread_one.getName());
        }


        /*JThread jThread_two = new JThread("JThread_Two");
        jThread_two.start();
        jThread_two.run(listTwo, false, true);
        try{
            jThread_two.join();
        }
        catch(InterruptedException e){
            System.out.printf("%s has been interrupted", jThread_two.getName());
        }*/

        System.out.println("Main thread finished...");
    }

}
