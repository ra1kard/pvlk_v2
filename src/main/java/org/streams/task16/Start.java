package org.streams.task16;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Start {

    public static void main(String[] args) {
        //вывод чисел по определенному принципу
        /*Stream.iterate(1, n -> n + 2)
                .limit(100)
                .forEach(System.out::println);*/

        //сформируйте последовательность случ чисел от 10 до 100 и вывести превышающие 50
        /*Random random = new Random();
        Stream.iterate(0, n -> random.nextInt(100) + 10)
                .limit(10)
                .filter(number -> number > 50)
                .forEach(System.out::println);*/

        //сформируйте последовательность случ чисел от 10 до 100 и поместить в список
        Random random = new Random();
        List<Integer> counts = Stream.iterate(0, n -> random.nextInt(100) + 10)
                .limit(10)
                .filter(number -> number > 50)
                .collect(Collectors.toList());
        System.out.println(counts);
    }

}
