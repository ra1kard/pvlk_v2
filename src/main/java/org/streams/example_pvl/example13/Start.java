package org.streams.example_pvl.example13;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {

        // ТЕРМИНАЛЬНЫЕ ОПЕРАТОРЫ

        // anyMatch(Predicate)
        // allMatch(Predicate)

        // Метод anyMatch используется для проверки,
        // соответствует ли хотя бы один элемент потока указанному предикату.
        ArrayList<String> list = new ArrayList<>(List.of("Прости", "Прощай", "Привет"));

        boolean isContains = list.stream()
                .anyMatch(string -> string.equalsIgnoreCase("привет"));
        System.out.println(isContains);


        System.out.println("\nЕЩЕ ПРИМЕР\n ");

        // Метод allMatch похож на метод anyMatch,
        // но, в отличие от него, метод allMatch вернёт true только в том случае,
        // если все элементы соответствуют указанному предикату.
        boolean isContain2 = list.stream()
                .allMatch(string -> string.equalsIgnoreCase("привет"));
        System.out.println(isContain2);
    }

}
