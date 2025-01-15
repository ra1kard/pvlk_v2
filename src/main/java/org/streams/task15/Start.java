package org.streams.task15;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Start {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Введите целое число n: ");
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(600);

        System.out.println("Список целых чисел:");
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 9, 2, 7, 4, 6);
        System.out.println(numbers);
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(600);

        System.out.println("Выведем те числа, которые превышают число n:");
        TimeUnit.MILLISECONDS.sleep(600);
        numbers.stream()
                .filter(number -> number > n)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Выведем сумму тех чисел, которые превышают число n:");
        int sum = numbers.stream()
                .filter(number -> number > n)
                .reduce(0, Integer::sum);   //.reduce(0, (number1, number2) -> number1 + number2);
        System.out.println(sum);
    }

}
