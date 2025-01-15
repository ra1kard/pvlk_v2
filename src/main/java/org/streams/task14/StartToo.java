package org.streams.task14;

import java.util.ArrayList;
import java.util.List;

public class StartToo {

    public static void main(String[] args) {
        ArrayList<String> listString = new ArrayList<>(List.of("hello", "world", "##", "!#@!-"));

        //фильтруем все строки, длина которых больше 4
        listString.stream()
                .filter(name -> name.length() > 4)
                .forEach(System.out::println);      //аналогично: .forEach(name -> System.out.println(name));
    }

}
