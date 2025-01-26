package org.streams.example_kuf.example6;

import java.util.Arrays;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // Параллельная обработка: умножаем каждое число на 2 и выводим
        numbers.parallelStream()
                .map(n -> n * 2)
                .forEach(System.out::println);

    }

}
