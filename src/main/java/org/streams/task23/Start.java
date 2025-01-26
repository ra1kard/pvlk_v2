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

        //TODO разобрать почему через reduce не получилось?
        // нашел вот: "Метод reduce() возвращает значение одного типа, и в данном случае вы пытаетесь вернуть Integer,
        // но используете его в качестве контейнера для Human. Вместо reduce() лучше использовать map() и sum()."
        // но не очень понял

        //при помощи stream() найдите суммарный возраст людей.
        /*Optional<Integer> sumAge = humans.stream()
                .reduce((humanFirst, humanSecond) -> (humanFirst.getAge() + humanSecond.getAge()))
        System.out.println(sumAge);*/

        Integer humanList = humans.stream()
                .map(h -> h.getAge())
                .reduce((h1, h2) -> h1 + h2).get();
        System.out.println(humanList);

        //при помощи stream() найдите суммарный возраст людей.
        /*int sumAge = humans.stream()
                .mapToInt(human -> human.getAge())      // преобразуем в IntStream
                .sum();                                         // суммируем
        System.out.println(sumAge);*/
    }

}
