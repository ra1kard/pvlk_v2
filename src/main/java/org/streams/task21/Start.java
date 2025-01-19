package org.streams.task21;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(List.of(25, 99, -80, 102, 26, 804, 44));
        ArrayList<Integer> list2 = new ArrayList<>(List.of(150, 785, 99, 800, -61, -856, 21));

        Comparator<Integer> SecondNumberComparator = (o1, o2) -> {
            String s1 = String.valueOf(Math.abs(o1));   //Обрабатываем отрицательные числа, используя Math.abs(), чтобы избежать проблем с лишним знаком минус при сравнении.
            String s2 = String.valueOf(Math.abs(o2));

            if (Character.getNumericValue(s1.charAt(1)) > Character.getNumericValue(s2.charAt(1))) return 1;
            if (Character.getNumericValue(s1.charAt(1)) < Character.getNumericValue(s2.charAt(1))) return -1;
            return 0;
        };

        list1.stream()
                .sorted(SecondNumberComparator)
                .forEach(System.out::println);

        System.out.println();

        list2.stream()
                .sorted(SecondNumberComparator)
                .forEach(System.out::println);
    }

}
