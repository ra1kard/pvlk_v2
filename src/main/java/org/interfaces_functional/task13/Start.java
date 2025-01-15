package org.interfaces_functional.task13;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Start {

    /*public static void main(String[] args) {
        String str1 = "10 + 25 * 2 + 3";                        // 63
        String str2 = "8 / 2 + 2";                              // 6
        String str3 = "50 / 10 + 2 ** 2 + 6 * 6 - 30";          // 15

        String[] arrayStr = str1.split(" ");
        ArrayList<String> list = new ArrayList<>(List.of(arrayStr));

        calculate(list, "**", (x, y) -> Math.pow(x, y));
        calculate(list, "*", (x, y) -> (x * y));
        calculate(list, "/", (x, y) -> (x / y));
        calculate(list, "+", (x, y) -> (x + y));
        calculate(list, "-", (x, y) -> (x - y));
    }

    public static void calculate(ArrayList<String> list, String sign, BinaryOperator<Double> binaryOperator) {
        int indexSymbol;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(sign)) {
                indexSymbol = i;
                System.out.println(list + " - найдем indexSymbol + " + sign  '**' = " + indexSymbol);

                //найдем левое и правое число число
                int numLeft = Integer.parseInt(list.get(indexSymbol-1));
                int numRight = Integer.parseInt(list.get(indexSymbol+1));

                int rsl = numLeft;
                for (int j = 0; j < numRight - 1; j++) {
                    rsl *= numLeft;
                }

                list.set(indexSymbol-1, String.valueOf(rsl));
                list.remove(indexSymbol);
                list.remove(indexSymbol);
                i--;
            }
        }



        *//*BinaryOperator<Integer> multiply = (x, y) -> x * y;
        System.out.println(multiply.apply(10, 20));*//*
    }*/

}

/*public interface BinaryOperator<T> {
    T apply(T t1, T t2);
}*/
