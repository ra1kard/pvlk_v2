package org.streams.example_pvl.example6;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        // skip(int)

        // Метод skip позволяет пропустить определённое количестве элементов в стриме.
        // Указывая целое число как параметр мы определяем количество элементов, которое будет пропущено
        ArrayList<Integer> list = new ArrayList<>(List.of(10, 17, 2000, 0, -555, 10, 10, 7));   // 10 10 7

        list.stream()
                .skip(5)
                .forEach(System.out::println);
    }

}
