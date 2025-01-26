package org.streams.example_pvl.example9;

import java.util.Arrays;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        // peek(Consumer)

        // Метод peek() выполняют операцию к каждому элементу.

        // Метод peek() удобен, когда необходимо выполнить дополнительные операции с элементами потока,
        // например, для целей логирования, отладки или профилирования, не меняя при этом сами элементы.

        // В общем случае, рекомендуется использовать peek() редко и, преимущественно, для отладки,
        // а не как средство модификации элементов потока.
        // Если требуется изменить элементы потока, предпочтительнее использовать метод map().

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        numbers.stream()
                .peek(System.out::println)
                .forEach(System.out::println);
    }

}
