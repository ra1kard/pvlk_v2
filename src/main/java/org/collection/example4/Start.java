package org.collection.example4;

import java.util.HashSet;
import java.util.Set;

public class Start {

    public static void main(String[] args) {
        Set<MutablePerson> set = new HashSet<>();
        MutablePerson p = new MutablePerson("Alice");
        set.add(p);
        System.out.println("До изменения: " + set.contains(p)); // true
        // Изменяем поле, влияющее на hashCode
        p.setName("Bob");
        System.out.println("После изменения: " + set.contains(p)); // Может быть false!
    }

}
