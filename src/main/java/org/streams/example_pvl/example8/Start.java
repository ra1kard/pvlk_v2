package org.streams.example_pvl.example8;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        // takeWhile(Predicate)
        // dropWhile(Predicate)

        // Метод takeWhile cоздает новый поток,
        // содержащий элементы исходного потока до тех пор, пока они удовлетворяют указанному условию.
        // Если первый элемент потока не соответствует предикату, новый поток будет пустым.

        // Для примера ниже выведутся числа 10, 17 и 2000,
        // так как -20 уже не подходит под условие, а значит, takeWhile останавливает свою работу.
        ArrayList<Integer> list = new ArrayList<>(List.of(10, 17, 2000, -20, -555, 10, 10, 7));

        list.stream()
                .takeWhile(integer -> integer > 0)
                .forEach(System.out::println);

        System.out.println("\nЕЩЕ ПРИМЕР\n ");

        // Метод dropWhile возвращает новый поток,
        // который включает все элементы исходного потока, начиная с первого элемента, не удовлетворяющего указанному условию.
        // В момент, когда предикат возвращает false, все последующие элементы из исходного потока включаются в новый поток.
        // По большому счёту, метод dropWhile противоположен takeWhile
        ArrayList<Integer> list2 = new ArrayList<>(List.of(10, 17, 2000, 0, -555, 10, 10, 7));

        list2.stream()
                .dropWhile(integer -> integer > 0)
                .forEach(System.out::println);
    }

}
