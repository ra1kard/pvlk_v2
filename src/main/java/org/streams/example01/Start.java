package org.streams.example01;

import java.util.Arrays;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Анна", "Ким", "Борис", "Виктор", "Галина", "Дмитрий");

        // Фильтруем имена, длина которых больше 4 символов, и выводим их
        names.stream()
                .filter(name -> name.length() > 4)
                .forEach(System.out::println);

    }


}
