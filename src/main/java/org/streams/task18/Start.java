package org.streams.task18;

import java.util.Scanner;
import java.util.function.UnaryOperator;

public class Start {

    public static void main(String[] args) {
        System.out.println("Введите число от 10:");
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();

        UnaryOperator<Integer> sum = x -> {
            String s = Integer.toString(x);
            return Character.getNumericValue(s.charAt(0)) + Character.getNumericValue(s.charAt(1));
        };
        System.out.println(sum.apply(n));
    }

}
