package org.streams.example_pvl.example1;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(10, 0, 2000, 4333, -555, 2345, 55, 7896));

        // filter(Predicate)

        // в примере ниже будут отсеяны все отрицательные числа.
        list.stream()
                .filter(x -> x > 0)
                .forEach(System.out::println);
    }

}
