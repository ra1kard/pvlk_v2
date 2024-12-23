package org.interfaces_functional.task11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>(List.of(
                new Item("Молоко ", 100, 4, 20, 3),     // 100, 10, 15, 5
                new Item("Соль   ", 120, 4, 20, 3),     // 120, 9, 14, 4
                new Item("КофеМол", 400, 4, 20, 3),     // 400, 7, 12, 4
                new Item("Спички ", 10, 4, 20, 3)       // 10, 4, 6, 2
        ));

        Comparator<Item> itemComparator = (o1, o2) -> {
            if (o1.getPrice() > o2.getPrice()) return 1;
            if (o1.getPrice() < o2.getPrice()) return -1;

            int volumeFirst = o1.getWidth() * o1.getHeight() * o1.getDepth();
            int volumeSecond = o2.getWidth() * o2.getHeight() * o2.getDepth();
            if (volumeFirst > volumeSecond) return 1;
            if (volumeFirst < volumeSecond) return -1;

            if (o1.getName().compareTo(o2.getName()) > 0) return 1;
            if (o1.getName().compareTo(o2.getName()) < 0) return -1;
            return 0;
        };

        items.sort(itemComparator);
        System.out.println(items);
    }

}
