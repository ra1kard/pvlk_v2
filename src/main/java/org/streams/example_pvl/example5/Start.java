package org.streams.example_pvl.example5;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        //limit(int)

        //В примере ниже показано как ограничить потоковую обработку первыми пятью элементами.
        ArrayList<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        list.stream()
                .limit(5)
                .forEach(System.out::println);
    }

}
