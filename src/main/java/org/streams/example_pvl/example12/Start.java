package org.streams.example_pvl.example12;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Start {

    public static void main(String[] args) {

        // ТЕРМИНАЛЬНЫЕ ОПЕРАТОРЫ

        // findFirst()

        // Метод findFirst возвращает Optional и служит для извлечения первого элемента из потока.
        // Он обычно используется в сочетании с методом filter.

        ArrayList<Integer> list = new ArrayList<>(List.of(10, 20, 30, 40, 50));

        Optional<Integer> sumOpt = list.stream()
                .filter(x -> x % 4 == 0)
                .findFirst();

        int number = sumOpt.get();
        System.out.println(number);

    }

}
