package org.collection.example1;

import java.util.ArrayList;
import java.util.List;

public class Start8 {

    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Яблоко");
        fruits.add("Банан");
        fruits.add("Апельсин");

        // Обход с использованием цикла for
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println(fruits.get(i));
        }
    }

}
