package org.streams.task20;

import java.util.ArrayList;
import java.util.List;

public class Start {

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

        //TODO как сделать что-то подобное?? ->
        /*listString.stream()
                .filter(x -> {
                    int count = 0;
                    if (x.contains("Toyota")) {
                        String[] arrayString = x.split(" ");
                        count += Integer.parseInt(arrayString[1]);
                    }
                    return false;
                })
                .forEach(System.out::println);*/

        // 1. оставить только тойоты
        List<String> res1 = listString.stream()
                .filter(s -> s.contains("Toyota"))
                .toList();
        System.out.println(res1);

        // 2. вычленить количество из тойот
        int count = 0;
        for (String r1 : res1) {
            String[] arrayString = r1.split(" ");
            count += Integer.parseInt(arrayString[1]);
        }
        System.out.println(count);
    }

}
