package org.streams.task20;

import java.util.ArrayList;
import java.util.List;

public class StartToo {

    public static void main(String[] args) {
        ArrayList<String> listString = new ArrayList<>(List.of(
                "Toyota 10",
                "Nissan 3",
                "BMW 7",
                "Toyota 4",
                "BMW 1",
                "Reno 17",
                "Nissan 7"
        ));

        int sum = listString.stream()
                .filter(s -> s.startsWith("Toyota"))
                .mapToInt(s -> Integer.parseInt(s.split(" ")[1]))
                .sum();
        System.out.println(sum);
    }

}
