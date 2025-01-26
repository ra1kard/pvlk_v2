package org.streams.example_pvl.example3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Start {

    public static void main(String[] args) {

        //flatMap()

        // Метод flatMap() позволяет создать один поток из множества потоков.
        // В качестве параметра принимает функцию, которая применяется к каждому элементу потока.

        // Рассмотрим пример, в котором двумерный список становится одномерным.
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>(List.of(10, 20, 30)));
        lists.add(new ArrayList<>(List.of(40, 50, 60)));

        lists.stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        System.out.println("\nЕЩЕ ПРИМЕР\n ");

        //В примере ниже рассмотрим ситуацию, когда из двумерного массива списков нужно оставить только чётные элементы
        List<List<Integer>> lists2 = new ArrayList<>();
        lists2.add(new ArrayList<>(List.of(10, 23, 30)));
        lists2.add(new ArrayList<>(List.of(40, 11, 60)));

        lists2.stream()
                .flatMap(Collection::stream)
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);

    }

}
