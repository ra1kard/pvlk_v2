package org.collection.example2;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person)) return false;
        Person other = (Person) obj;
        return name.equals(other.name) && age == other.age;
    }

    public static void main(String[] args) {
        Person person1 = new Person("Nik", 6);
        Person person2 = new Person("Jak", 7);
        System.out.println(person1.equals(person1));
        System.out.println(person1.equals(person2));
    }

}
