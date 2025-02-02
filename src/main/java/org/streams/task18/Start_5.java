package org.streams.task18;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Comparator;
import java.util.function.UnaryOperator;

public class Start_5 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 16, 98, 23);
        Map<Integer, Integer> numberSumMap = new HashMap<>();

        // функциональный интерфейс, вычисляющий сумму цифр числа
        UnaryOperator<Integer> sumOfDigits = x ->
                Integer.toString(x)
                        .chars()
                        .map(Character::getNumericValue)
                        .sum();

        // заполняем HashMap числами и их суммами
        numbers.forEach(n -> numberSumMap.put(n, sumOfDigits.apply(n)));

        // находим число с максимальной суммой цифр
        Optional<Integer> maxNumber = numberSumMap.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey);

        maxNumber.ifPresent(System.out::println);
    }
}
