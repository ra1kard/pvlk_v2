package org.streams.example_pvl.example2;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(10, 0, 2000, 4333, -555, 2345, 55, 7896));

        //map(Function)

        // Метод map принимает функциональный интерфейс Function.
        // Метод map предназначен для обработки данных и их преобразования
        // После себя он отправляет по потоку уже обработанные (изменённые) данные

        // В примере ниже каждый элемент коллекции делит на 10
        list.stream()
                .map(integer -> integer / 10)
                .forEach(System.out::println);

        System.out.println("\nЕЩЕ ПРИМЕР\n ");

        // В примере ниже каждое число преобразуется в строку
        list.stream()
                .map(integer -> integer + " рублей")
                .forEach(System.out::println);
    }

}
