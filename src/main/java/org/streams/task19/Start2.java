package org.streams.task19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class Start2 {

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

        Optional<Integer> sum = listString.stream()
                .map(findSymbolA)
                .max(Comparator.naturalOrder());
        System.out.println(sum.get());

    }

}
