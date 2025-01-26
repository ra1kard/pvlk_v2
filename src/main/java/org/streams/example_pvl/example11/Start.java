package org.streams.example_pvl.example11;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Start {

    public static void main(String[] args) {

        // ТЕРМИНАЛЬНЫЕ ОПЕРАТОРЫ

        // reduce()

        // Метод reduce применяется для комбинирования элементов потока в одно значение.
        // Он отличается от метода collect тем, что использует ассоциативную функцию,
        // принимающую два значения и объединяющую их в одно.
        // Например, метод reduce можно использовать для суммирования чисел
        // или для нахождения максимального или минимального числа.

        // Метод reduce возвращает Optional - специальный тип-обёртка.
        // Необходим для безопасной обработки данных, так как в случае Exception программа не падает.

        ArrayList<Integer> list = new ArrayList<>(List.of(10, 20, 30, 40, 50));

        Optional<Integer> sumOpt = list.stream()
                .reduce((a, b) -> a + b);       // или так:  .reduce(Integer::sum);

        int sum = sumOpt.get();
        System.out.println(sum);

    }

}
