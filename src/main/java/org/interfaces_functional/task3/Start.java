package org.interfaces_functional.task3;

import org.interfaces_functional.example1.Predicate;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>(List.of("доход", "мясо", "мадам"));   // доход
        ArrayList<String> list2 = new ArrayList<>(List.of("сало", "мыло", "око"));      // око

        System.out.println(longestPalindrom(list1));
        System.out.println(longestPalindrom(list2));
    }

    // Реализуйте функциональный интерфейс Predicate, который должен определять является ли строка палиндромом
    // Используя реализованный интерфейс найдите и выведите самый длинный палиндром в списке строк
    public static String longestPalindrom(ArrayList<String> list) {
        String rsl = "";

        Predicate<String> isPalindrom = s -> {
            char[] characterArrayList = s.toCharArray();
            for (int i = 0; i < characterArrayList.length/2; i++) {
                if (characterArrayList[i] != characterArrayList[characterArrayList.length-i-1]) {
                    return false;
                }
            }
            return true;
        };

        for (String s : list) {
            if (isPalindrom.test(s) && (s.length() > rsl.length())) {
                rsl = s;
            }
        }

        return rsl;
    }

}
