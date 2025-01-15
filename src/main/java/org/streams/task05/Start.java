package org.streams.task05;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Start {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("яблоко", "апельсин", "банан", "авокадо", "вишня", "арахис");

        // Группируем слова по первой букве
        Map<Character, List<String>> grouped = words.stream()
                .collect(Collectors.groupingBy(word -> word.charAt(0)));
        System.out.println(grouped);

    }

}
