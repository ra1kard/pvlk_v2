package org.interfaces_functional.task9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>(List.of(
                new Animal("Петя", 32),
                new Animal("Вова", 16),
                new Animal("Катя", 13),
                new Animal("Соня", 39)
        ));

        Comparator<Animal> animalComparator = (o1, o2) -> {
            if (o1.getAge() > o2.getAge()) return 1;
            if (o1.getAge() < o2.getAge()) return -1;
            return 0;
        };

        animals.sort(animalComparator);
        System.out.println(animals);
    }

}
