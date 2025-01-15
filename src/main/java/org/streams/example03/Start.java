package org.streams.example03;

import java.util.Arrays;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 9, 2, 7, 4, 6);

        // Сортируем числа, ограничиваем до первых 5 и выводим
        numbers.stream()
                .sorted()
                .limit(5)
                .forEach(System.out::println);

    }

}
