package org.streams.task14;

import java.util.Arrays;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Анна", "Борис", "Виктор", "Галина", "Дмитрий");

        //фильтруем все строки, длина которых больше 5
        names.stream()
                .filter(name -> name.length() > 5)
                .forEach(System.out::println);      //аналогично: .forEach(name -> System.out.println(name));
    }

}
