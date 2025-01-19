package org.streams.task19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class Start {

    public static void main(String[] args) {
        ArrayList<String> listString = new ArrayList<>(List.of(
                "А бабушка ела чипсы?",                                                                             //4
                "Фильм 'охота' покорил сердца многих зрителей той трагедией, которая развернулась на экранах...",   //9
                "На беснующегося Ведьмака напали злые вампиры",                                                     //6
                "Аллилуйя - Алла взяла пачку сигарет!",                                                             //6
                "уруруру")                                                                                          //0
        );

        // функциональный интерфейс, вычисляющий количество букв "а" в строке
        Function<String, Integer> findSymbolA = x -> {
            int count = 0;
            String s = x.toLowerCase();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'а') {
                    count++;
                }
            }
            return count;
        };
        //System.out.println(findSymbolA.apply(listString.get(0)));

        // 1. запишем количество букв "а" в строке в отдельный лист
        List<Integer> sum = listString.stream()
                .map(findSymbolA)
                .toList();
        System.out.println(sum);

        // 2. пройдемся по лист и найдем максимум
        Optional<Integer> max = sum.stream()
                .max(Comparator.naturalOrder());
        System.out.println(max.get());

        // 3. найдем у какой строки такое значение максимум
        listString.stream()
                .filter(s -> findSymbolA.apply(s).equals(max.get()))
                .forEach(System.out::println);
    }

}
