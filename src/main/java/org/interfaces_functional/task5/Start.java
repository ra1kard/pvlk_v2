package org.interfaces_functional.task5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Start {

    public static void main(String[] args) {
        Function<ArrayList<String>, String> findBiggestString = new Function<ArrayList<String>, String>() {
            @Override
            public String apply(ArrayList<String> strings) {
                String maxString = "";
                for (String string : strings) {
                    if (string.length() > maxString.length()) {
                        maxString = string;
                    }
                }
                return maxString;
            }
        };

        ArrayList<String> stringsList = new ArrayList<>(List.of("Первый", "Второй", "Длинное словечко", "Окончание"));
        System.out.println(findBiggestString.apply(stringsList));
    }

}
