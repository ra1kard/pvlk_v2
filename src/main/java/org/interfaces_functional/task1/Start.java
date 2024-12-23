package org.interfaces_functional.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Start {

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(List.of(25, 99, -8, 102, 26, 804, 44));  // 70
        ArrayList<Integer> list2 = new ArrayList<>(List.of(-7, 666, 27, 39, 11, 0));        // 0
        ArrayList<Integer> list3 = new ArrayList<>(List.of(10, 20, 30, 40));                // 100

        System.out.println(sumEvenTwoDigitNumbers(list1));
        System.out.println(sumEvenTwoDigitNumbers(list2));
        System.out.println(sumEvenTwoDigitNumbers(list3));
    }

    public static int sumEvenTwoDigitNumbers(ArrayList<Integer> list) {
        int sum = 0;

        //вариант записи через лямбду
        Predicate<Integer> predicateEvenTwoDigitNumbers =
                i -> ((i % 2 == 0) && ((i > 9 && i < 100) || (i > -100 && i < -9)));

        //вариант записи стандартный
        /*Predicate<Integer> predicateEvenTwoDigitNumbers = new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                return ((i % 2 == 0) && ((i > 9 && i < 100) || (i > -100 && i < -9)));
            }
        };*/

        for (Integer l : list) {
            if (predicateEvenTwoDigitNumbers.test(l)) {
                sum += l;
            }
        }
        return sum;
    }

}
