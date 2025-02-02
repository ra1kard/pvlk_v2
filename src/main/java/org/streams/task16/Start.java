package org.streams.task16;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Start {

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> counts = Stream
                .iterate(0, n -> random.nextInt(100) + 10)
                .limit(10)
                .filter(number -> number > 60)
                .collect(Collectors.toList());
        System.out.println(counts);
    }

}
