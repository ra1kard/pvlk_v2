package org.streams.task04;

import java.util.Arrays;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        // Вычисляем сумму всех чисел
        int sum = numbers.stream()
                .reduce(10, Integer::sum);

        System.out.println("Сумма: " + sum);

    }

}
