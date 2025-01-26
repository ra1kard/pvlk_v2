package org.streams.example_pvl.example7;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        //sorted()

        // Метод sorted позволяет отсортировать данные.
        // Метод sorted взаимодействует с Comparable объектами, поэтому со стандартными типами данных проблем не возникает.
        // Строки сортируются по алфавиту, числа - по возрастанию.
        // Если это будут кастомные объекты, тогда для них необходимо будет определить интерфейс Comparable.

        ArrayList<Integer> list = new ArrayList<>(List.of(10, 17, 2000, 0, -555, 10, 10, 7));

        list.stream()
                .sorted()
                .forEach(System.out::println);
    }

}
