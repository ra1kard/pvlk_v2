package org.interfaces_functional.example3;

public class Human {
    private String surname;
    private String name;
    private int age;

    public Human(String surname, String name, int age) {
        this.surname = surname;
        this.name = name;
        this.age = age;
    }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return "Human{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
