package org.streams.task24;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        Student student1 = new Student("s1");
        Student student2 = new Student("ss2");
        Student student3 = new Student("ss3");

        student1.addMark(5);
        student1.addMark(5);
        student1.addMark(5);

        student2.addMark(3);
        student2.addMark(4);
        student2.addMark(4);

        student3.addMark(5);
        student3.addMark(5);
        student3.addMark(2);

        Group group1 = new Group("g1");
        group1.addStudent(student1);
        group1.addStudent(student2);
        group1.addStudent(student3);

        System.out.println("Вывод1 getAverageMark");
        System.out.println(student1.getName() + " " + student1.getAverageMark());
        System.out.println(student2.getName() + " " + student2.getAverageMark());
        System.out.println(student3.getName() + " " + student3.getAverageMark());
        System.out.println();

        //попробуем просто вывести по имени
        System.out.println("Вывод2 по наличию 'ss'");
        group1.students.stream()
                .filter(student -> student.getName().contains("ss"))
                .forEach(student -> System.out.println(student.getName()));
        System.out.println();

        //попробуем вывести сортировку
        System.out.println("Вывод3 попробуем вывести без сортировки");
        for (Student student : group1.students) {
            System.out.println(student.getAverageMark());
        }

        System.out.println("Вывод3 попробуем вывести сортировку2");
        List<Student> sortedStudents = group1.students.stream()
                .sorted(Comparator.comparingInt(Student::getAverageMark))
                .toList();

        for (Student sortedStudent : sortedStudents) {
            System.out.println(sortedStudent.getAverageMark());
        }
    }

}
