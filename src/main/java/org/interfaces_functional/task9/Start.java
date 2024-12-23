package org.interfaces_functional.task9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>(List.of(
                new Animal("catВася", 32),
                new Animal("dogКузя", 16),
                new Animal("catЛуна", 13),
                new Animal("DogРонн", 39)
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
