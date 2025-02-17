package org.collection.example1;

import java.util.ArrayList;
import java.util.List;

public class Start4 {

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        System.out.println(arrayList.get(0)); // Вывод: Apple

        System.out.println();
        for (String s : arrayList) {
            System.out.println(s);
        }
    }

}
