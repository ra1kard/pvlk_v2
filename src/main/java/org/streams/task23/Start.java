package org.streams.task23;

import java.util.*;
import java.util.function.Supplier;

public class Start {

    public static void main(String[] args) {
        Supplier<Human> humanSupplier = () -> {
            System.out.println("Создание Human!");
            Scanner console = new Scanner(System.in);
            Random random = new Random();
            System.out.println("Введите name:");
            String name = console.nextLine();
            System.out.println("Введите surname:");
            String surname = console.nextLine();
            System.out.println();
            return new Human(name, surname, random.nextInt(90));
        };

        Human human1 = humanSupplier.get();
        Human human2 = humanSupplier.get();
        Human human3 = humanSupplier.get();
        Human human4 = humanSupplier.get();
        Human human5 = humanSupplier.get();

        ArrayList<Human> humans = new ArrayList<>(List.of(human1, human2, human3, human4, human5));
        for (Human human : humans) {
            System.out.println("Имя Human: " + human.getName() + ", возраст: " + human.getAge());
        }

        //при помощи stream() найдите суммарный возраст людей.

        // ВАРИАНТ 1
        Integer humanList = humans.stream()
                .map(h -> h.getAge())
                .reduce((h1, h2) -> h1 + h2).get();
        System.out.println(humanList);

        // ВАРИАНТ 2
        /*int sumAge = humans.stream()
                .mapToInt(human -> human.getAge())      // преобразуем в IntStream
                .sum();                                         // суммируем
        System.out.println(sumAge);*/
    }

}
