package org.streams.task17;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Start {

    public static void main(String[] args) {
        System.out.println("Введите целое число n - это будет количество чисел в последовательности: ");
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();

        /*for (int i = 1; i < 11; i++) {
            System.out.println(Math.pow(2, i - 1));
        }*/

        /*Stream.iterate(0, x -> (int) Math.pow(2, x - 1))
                .limit(n)
                .forEach(System.out::println);*/

        /*Stream.iterate(0, x -> x + 1)
                .map(x -> (int) Math.pow(2, x))
                .limit(n)
                .forEach(System.out::println);*/

        /*List<Integer> listString = Stream.iterate(0, x -> x + 1)
                .map(x -> (int) Math.pow(2, x))
                .limit(n)
                .collect(Collectors.toList());
        System.out.println(listString);*/

        ArrayList<Integer> listString = (ArrayList<Integer>) Stream.iterate(0, x -> x + 1)
                .map(x -> (int) Math.pow(2, x))
                .limit(n)
                .collect(Collectors.toList());
        System.out.println(listString);
    }

}
