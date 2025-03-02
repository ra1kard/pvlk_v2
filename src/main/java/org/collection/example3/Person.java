package org.collection.example3;

import java.util.Objects;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Переопределяем equals
    @Override
    public boolean equals(Object obj) {
        // Проверка на самосравнение
        if (this == obj) return true;
        // Если передали null или объекты разных классов, считаем их не равными
        if (obj == null || getClass() != obj.getClass()) return false;
        Person other = (Person) obj;
        // Сравниваем по значимым полям
        return age == other.age &&
                (name != null ? name.equals(other.name) : other.name == null);
    }

    // Переопределяем hashCode
    @Override
    public int hashCode() {
        int result = 17; // произвольное начальное число
        result = 31 * result + age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    // Для удобства выводим объект в консоль
    @Override
    public String toString() {
        return "Person{name='" + name + '\'' + ", age=" + age + '}';
    }

    public static void main(String[] args) {
        Person person1 = new Person("John", 20);
        System.out.println(person1);
        System.out.println(person1.toString());

        Person person2 = new Person("Joe", 22);
        System.out.println(person1.equals(person1));
        System.out.println(person1.equals(person2));

        Objects.hash(person1);
    }

}
