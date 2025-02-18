package org.collection.example1;

import java.util.ArrayList;
import java.util.Iterator;

public class Start14 {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println("Список до удаления: " + list);

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String item = it.next();
            if ("B".equals(item)) {
                it.remove(); // Безопасное удаление через итератор
            }
        }

        System.out.println("Список после безопасного удаления: " + list);
    }

}
