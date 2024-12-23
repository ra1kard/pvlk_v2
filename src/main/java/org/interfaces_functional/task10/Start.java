package org.interfaces_functional.task10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>(List.of(
                new Animal("Гуну", 12),
                new Animal("Буну", 3),
                new Animal("Анну", 6),
                new Animal("Вуну", 12)
        ));

        Comparator<Animal> animalComparator = (o1, o2) -> {
            if (o1.getAge() > o2.getAge()) return 1;
            if (o1.getAge() < o2.getAge()) return -1;
            if (o1.getName().compareTo(o2.getName()) > 0) return 1;
            if (o1.getName().compareTo(o2.getName()) < 0) return -1;
            return 0;
        };

        animals.sort(animalComparator);
        System.out.println(animals);
    }

}
