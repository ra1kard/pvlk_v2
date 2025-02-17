package org.collection.example1;

import java.util.LinkedList;
import java.util.List;

public class Start5 {

    public static void main(String[] args) {
        List<String> linkedList = new LinkedList<>();
        linkedList.add("Apple");
        linkedList.add("Banana");
        System.out.println(linkedList.get(0)); // Вывод: Apple

        System.out.println();
        for (String s : linkedList) {
            System.out.println(s);
        }
    }

}
