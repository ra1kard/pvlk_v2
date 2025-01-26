package org.streams.example_pvl.example4;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        //distinct()

        //Метод distinct оставляет только уникальные элементы.
        ArrayList<Integer> list = new ArrayList<>(List.of(1, 1, 2, 3, 3));      // вывод: 1, 2, 3

        list.stream()
                .distinct()
                .forEach(System.out::println);

    }

}
