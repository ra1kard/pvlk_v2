package org.interfaces_functional.task2;

import org.interfaces_functional.example1.Predicate;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>(
                List.of("Перемена", "метель", "солнце", "Крепость еще далеко"));                // 2
        ArrayList<String> list2 = new ArrayList<>(
                List.of("Ручей", "липа", "зелень", "Бегемот", "веретено на столе", "Пряжа"));   // 1
        ArrayList<String> list3 = new ArrayList<>(
                List.of("Лего", "перелёт", "Снегопад", "На улице дождь"));                      // 0

        System.out.println(sumStringFitsConditions(list1));
        System.out.println(sumStringFitsConditions(list2));
        System.out.println(sumStringFitsConditions(list3));
    }

    public static int sumStringFitsConditions(ArrayList<String> list) {
        int sum = 0;

        //вариант записи через лямбду
        Predicate<String> predicateWithFirstSimbolUpperCaseAndThereIsLetterETwice = s -> {
            int count = 0;
            if (Character.isUpperCase(s.charAt(0)) && s.contains("е")) {
                char[] characterArrayList = s.toCharArray();
                for (char c : characterArrayList) {
                    if (c == 'е') {
                        count++;
                    }
                }
            }
            return (count > 1);
        };

        //вариант записи стандартный
        /*Predicate<String> predicateWithFirstSimbolUpperCaseAndThereIsLetterETwice = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                int count = 0;
                if (Character.isUpperCase(s.charAt(0)) && s.contains("е")) {
                    char[] characterArrayList = s.toCharArray();
                    for (char c : characterArrayList) {
                        if (c == 'е') {
                            count++;
                        }
                    }
                }
                return (count > 1);
            }
        };*/

        for (String s : list) {
            if (predicateWithFirstSimbolUpperCaseAndThereIsLetterETwice.test(s)) {
                sum++;
            }
        }

        return sum;
    }

}
