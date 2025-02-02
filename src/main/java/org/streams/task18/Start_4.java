package org.streams.task18;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.UnaryOperator;

public class Start_4 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 16, 98, 23);

        // функциональный интерфейс, вычисляющий сумму цифр числа
        UnaryOperator<Integer> sumOfDigits = x ->
                Integer.toString(x)
                        .chars()
                        .map(Character::getNumericValue)
                        .sum();

        // находим число с максимальной суммой цифр
        Optional<Integer> maxNumber = numbers.stream()
                .map(sumOfDigits)
                .max(Comparator.naturalOrder());
        maxNumber.ifPresent(System.out::println);
    }

}
