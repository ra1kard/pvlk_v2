package org.collection.example1;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Apple"); // Дубликаты разрешены

        for (String s : list) {
            System.out.println(s);
        }

        System.out.println();
        System.out.println(list.get(1));
    }

}
