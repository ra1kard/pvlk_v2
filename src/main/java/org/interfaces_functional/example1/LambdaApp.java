package org.interfaces_functional.example1;

import java.util.function.Predicate;

public class LambdaApp {

    public static void main(String[] args) {
        Predicate<Integer> isPositive = x -> x > 0; //-> Это лямбда выражение - анонимная функция. Проще говоря, это метод без объявления (без модификаторов доступа, возвращающие значение и имя).

        System.out.println(isPositive.test(5)); // true
        System.out.println(isPositive.test(-7)); // false
    }

}
