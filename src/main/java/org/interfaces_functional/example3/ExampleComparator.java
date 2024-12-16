package org.interfaces_functional.example3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ExampleComparator {

    public static void main(String[] args) {
        ArrayList<Human> humans = new ArrayList<>(
                List.of(
                        new Human("Максимов", "Илья", 30),
                        new Human("Смирнов", "Александр", 18),
                        new Human("Владимиров", "Константин", 49),
                        new Human("Лукина", "Ольга", 16),
                        new Human("Лапина", "Анна", 30),
                        new Human("Аквинский", "Фома", 99),
                        new Human("Асафьев", "Стас", 16)
                )
        );

        Comparator<Human> humanComparator = (o1, o2) -> {
            if (o1.getAge() > o2.getAge()) return 1;
            if (o1.getAge() < o2.getAge()) return -1;
            return 0;
        };

        // Теперь, доработаем сортировку таким образом,
        // чтобы в случае одинакового возраста объекты упорядочиваются по фамилии.
        /*Comparator<Human> humanComparator = (o1, o2) -> {
            if (o1.getAge() > o2.getAge()) return 1;
            if (o1.getAge() < o2.getAge()) return -1;
            if (o1.getSurname().compareTo(o2.getSurname()) > 0) return 1;
            if (o1.getSurname().compareTo(o2.getSurname()) < 0) return -1;
            return 0;
        };*/

        humans.sort(humanComparator);
        System.out.println(humans);
    }

}
