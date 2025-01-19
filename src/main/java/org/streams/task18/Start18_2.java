package org.streams.task18;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.UnaryOperator;

public class Start18_2 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 16, 98, 23);

        //функциональный интерфейс, вычисляющий сумму цифр числа
        UnaryOperator<Integer> sum = x -> {
            String s = Integer.toString(x);
            return Character.getNumericValue(s.charAt(0)) + Character.getNumericValue(s.charAt(1));
        };

        //1. запишем сумму цифр чисел в отдельный лист
        List<Integer> numbersNew = numbers.stream()
                .map(sum)
                .toList();

        //2. пройдемся по листу и найдем максимум
        Optional<Integer> max = numbersNew.stream()
                .max(Comparator.naturalOrder());
        System.out.println(max.get());

        //3. найдем изначальное число, сумма цифр которого является максимальной
        //TODO уточнить почему предлагается вместо == equals, ведь это числа, а не строки
        numbers.stream()
                .filter(n -> sum.apply(n) == (max.get()))
                .forEach(System.out::println);
    }

}
