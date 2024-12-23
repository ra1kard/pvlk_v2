package org.interfaces_functional.task4;

public class Start {

    public static void main(String[] args) {
        //часть 1
        Max3<Integer> refInt = (a, b, c) -> {
            int maxValue = (a > b) ? a : b;
            maxValue = (maxValue > c) ? maxValue : c;
            return maxValue;
        };

        int res = refInt.apply(5, 7, 3);      // res = 7
        System.out.println("res = " + res);

        //часть 2
        Max3<Double> refDouble = (a, b, c) -> {
            Double maxValue = (a > b) ? a : b;
            maxValue = (maxValue > c) ? maxValue : c;
            return maxValue;
        };

        double resMax = refDouble.apply(3.88, 2.55, 4.11);
        System.out.println("resMax = " + resMax);
    }

    //TODO: уточнить возвращаемое мы пишем в реализации или как?
    //TODO: уточнить тут надо было Comparator юзать просто через @Override?
    public interface Max3<T> {          //аналог BinaryOperator
        T apply(T t1, T t2, T t3);
    }

}
