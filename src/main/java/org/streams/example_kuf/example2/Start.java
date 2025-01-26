package org.streams.example_kuf.example2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Start {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("анна", "борис", "виктор");

        // Преобразуем имена в верхний регистр и собираем в новый список
        List<String> upperNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(upperNames);


    }
}
