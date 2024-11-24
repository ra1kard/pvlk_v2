package org.hashSet;

import java.util.*;

public class Task7 {
    public static void main(String[] args) {
        HashSet<Integer> numbersOne = new HashSet<>(Arrays.asList(10, 90, 30, 40, 50, 60));
        HashSet<Integer> numbersTwo = new HashSet<>(Arrays.asList(11, 90, 33, 40, 55, 60));
        List<Integer> list = new ArrayList<>();


        for (Integer i : numbersOne) {
            if (numbersTwo.contains(i)) {
                list.add(i);
            }
        }
        System.out.println(list);

        TreeSet<Integer> numbersTree = new TreeSet<>(list);
        System.out.println(numbersTree);
    }
}
