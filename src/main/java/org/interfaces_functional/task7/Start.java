package org.interfaces_functional.task7;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Start {

    public static void main(String[] args) {
        Function<ArrayList<Integer>, Integer> findSum = list -> {
            int sum = 0;
            for (Integer i : list) {
                sum += i;
            }
            return sum;
        };

        ArrayList<Integer> list = new ArrayList<>(List.of(3, 7, 5, 1));
        System.out.println(findSum.apply(list));
    }

}
