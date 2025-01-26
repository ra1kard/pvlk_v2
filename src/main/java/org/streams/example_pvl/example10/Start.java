package org.streams.example_pvl.example10;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Start {

    public static void main(String[] args) {

        // ТЕРМИНАЛЬНЫЕ ОПЕРАТОРЫ

        // сollect(Collector)

        // Метод collect часто используется в конвейере потока.
        // Его применяют для сбора результата потока в определенную структуру: строку, коллекцию (List, Set, Map).

        // Метод принимает объект типа Collector в качестве аргумента,
        // который определяет способ осуществления операции подсчета.

        // В примере ниже элементы исходного списка фильтруются (остаются только положительные),
        // затем каждый элемент делится на 10, а после этого всё что осталось собирается в новый List.

        ArrayList<Integer> list = new ArrayList<>(List.of(10, 17, 2000, 0, -555, 10, 10, 7));

        List<Integer> result = list.stream()
                .filter(num -> num > 0)
                .map(num -> num / 10)
                .collect(Collectors.toList());

        System.out.println(result);

        System.out.println("\nЕЩЕ ПРИМЕР\n ");

        // Аналогично предыдущему варианту, но здесь всё собирается в Set.
        ArrayList<Integer> list2 = new ArrayList<>(List.of(10, 17, 2000, 0, -555, 10, 10, 7));

        Set<Integer> result2 = list2.stream()
                .filter(num -> num > 0)
                .map(num -> num / 10)
                .collect(Collectors.toSet());

        System.out.println(result2);


    }

}
