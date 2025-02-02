package org.streams.task18;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.UnaryOperator;

public class Start_3 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 16, 98, 23);

        //функциональный интерфейс, вычисляющий сумму цифр числа
        UnaryOperator<Integer> sumOfDigits = x -> {
            return Integer.toString(x)
                    .chars()
                    .map(Character::getNumericValue)
                    .sum();
        };

        //1. запишем сумму цифр чисел в отдельный лист
        List<Integer> numbersNew = numbers.stream()
                .map(sumOfDigits)
                .toList();

        //2. пройдемся по листу и найдем максимум
        Optional<Integer> max = numbersNew.stream()
                .max(Comparator.naturalOrder());
        System.out.println(max.get());

        //3. найдем изначальное число, сумма цифр которого является максимальной
        numbers.stream()
                .filter(n -> sumOfDigits.apply(n) == (max.get()))
                .forEach(System.out::println);
    }

}
