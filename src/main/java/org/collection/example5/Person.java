package org.collection.example5;

import java.util.Date;

public class Person {
    private final String name;
    private final Date birthDate; // Date – изменяемый класс

    public Person(String name, Date birthDate) {
        this.name = name;
        // Создаем копию объекта Date для защиты внутреннего состояния
        this.birthDate = new Date(birthDate.getTime());
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        // Возвращаем копию, а не оригинальный объект
        return new Date(birthDate.getTime());
    }
}
