package org.collection.example1;

import java.util.HashSet;
import java.util.Set;

public class Start6 {

    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Banana");
        System.out.println(hashSet.contains("Apple")); // Вывод: true

        System.out.println();
        for (String s : hashSet) {
            System.out.println(s);

        }
    }

}
