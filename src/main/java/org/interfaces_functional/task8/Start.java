package org.interfaces_functional.task8;

import java.util.function.Function;

public class Start {

    //TODO: уточнить как читать \\s
    public static void main(String[] args) {
        Function<String, String> deleteSpace = string -> {
            String rsl = string.trim();
            return rsl.replaceAll("\\s+", " ");
        };

        String s1 = "  Мне      16 лет";                            // Мне 16 лет
        String s2 = "Границы    разумного были   проигнорированы";  // Границы разумного были проигнорированы
        System.out.println(deleteSpace.apply(s1));
        System.out.println(deleteSpace.apply(s2));
    }

}
