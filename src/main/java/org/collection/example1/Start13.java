package org.collection.example1;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class Start13 {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        try {
            for (String item : list) {
                // Попытка модификации коллекции во время итерации
                if ("B".equals(item)) {
                    list.remove(item); // Это вызовет ConcurrentModificationException
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Исключение: " + e);
        }
    }

}
