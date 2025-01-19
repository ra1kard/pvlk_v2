package org.streams.task18;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.UnaryOperator;

public class Start18_2 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 16, 98, 23);

        UnaryOperator<Integer> sum = x -> {
            String s = Integer.toString(x);
            return Character.getNumericValue(s.charAt(0)) + Character.getNumericValue(s.charAt(1));
        };

        List<Integer> numbersNew = numbers.stream()
                .map(sum)
                .toList();

        Optional<Integer> max = numbersNew.stream()
                .max(Comparator.naturalOrder());
        System.out.println(max.get());
    }

}
