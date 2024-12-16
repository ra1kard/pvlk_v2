package org.interfaces_functional.task1;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        /*Predicate<Integer> chooseEvenTwoDigitNumbers_v1 = x -> x > 100;
        System.out.println(chooseEvenTwoDigitNumbers_v1.test(10));     // false
        System.out.println(chooseEvenTwoDigitNumbers_v1.test(100));    // false
        System.out.println(chooseEvenTwoDigitNumbers_v1.test(101));    // true*/

        /*Predicate<Integer> chooseEvenTwoDigitNumbers_v2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return (number % 2 == 0) && ((number > 9 && number < 100) || (number > -100 && number < -9));
            }
        };

        System.out.println(chooseEvenTwoDigitNumbers_v2.test(70));
        System.out.println(chooseEvenTwoDigitNumbers_v2.test(-34));
        System.out.println(chooseEvenTwoDigitNumbers_v2.test(0));
        System.out.println(chooseEvenTwoDigitNumbers_v2.test(100));*/

        /*Predicate<Integer> chooseEvenTwoDigitNumbers_v3 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return false;
            }

            @Override
            public Integer test(int number) {
                if ((number % 2 == 0) && ((number > 9 && number < 100) || (number > -100 && number < -9))) {
                    return number;
                }
                return 0;
            }
        };

        System.out.println(chooseEvenTwoDigitNumbers_v3.test(70));
        System.out.println(chooseEvenTwoDigitNumbers_v3.test(-34));
        System.out.println(chooseEvenTwoDigitNumbers_v3.test(0));
        System.out.println(chooseEvenTwoDigitNumbers_v3.test(100));*/

        Predicate<Integer> chooseEvenTwoDigitNumbers_v4 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return false;
            }

            @Override
            public Integer test(int number) {
                if ((number % 2 == 0) && ((number > 9 && number < 100) || (number > -100 && number < -9))) {
                    return number;
                }
                return 0;
            }

            //TODO: уточнить почему не смог в for подставить int сразу
            @Override
            public Integer test(ArrayList list) {
                int sum = 0;
                for (Object number : list) {
                    int i = (Integer) number;
                    if ((i % 2 == 0) && ((i > 9 && i < 100) || (i > -100 && i < -9))) {
                        sum += i;
                    }
                }
                return sum;
            }
        };

        ArrayList<Integer> list1 = new ArrayList<>(List.of(25, 99, -8, 102, 26, 804, 44));  // 70
        ArrayList<Integer> list2 = new ArrayList<>(List.of(-7, 666, 27, 39, 11, 0));        // 0
        ArrayList<Integer> list3 = new ArrayList<>(List.of(10, 20, 30, 40));                // 100

        System.out.println(chooseEvenTwoDigitNumbers_v4.test(list1));
        System.out.println(chooseEvenTwoDigitNumbers_v4.test(list2));
        System.out.println(chooseEvenTwoDigitNumbers_v4.test(list3));
    }

}
