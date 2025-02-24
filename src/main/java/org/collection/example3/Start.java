package org.collection.example3;

import java.util.HashSet;
import java.util.Set;

public class Start {

    public static void main(String[] args) {
        Person person1 = new Person("Alice", 30);
        Person person2 = new Person("Alice", 30);
        Person person3 = new Person("Bob", 25);

        Set<Person> set = new HashSet<>();
        set.add(person1);
        set.add(person2);
        set.add(person3);

        System.out.println("Размер множества: " + set.size());
        for (Person p : set) {
            System.out.println(p);
        }

    }

}
