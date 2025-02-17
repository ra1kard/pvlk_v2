package org.collection.example1;

import java.util.HashSet;
import java.util.Set;

public class Start2 {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Apple"); // Дубликаты не разрешены, "Apple" добавится только один раз

        for (String s : set) {
            System.out.println(s);
        }
    }

}
