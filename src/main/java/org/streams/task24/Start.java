package org.streams.task24;

import java.util.*;
import java.util.stream.Collectors;

public class Start {

    public static void main(String[] args) {
        Student student1 = new Student("Яна");
        Student student2 = new Student("Алла");
        Student student3 = new Student("Гарик");

        student1.addMark(5);
        student1.addMark(5);
        student1.addMark(5);
        student1.addMark(5);
        student1.addMark(4);

        student2.addMark(4);
        student2.addMark(4);
        student2.addMark(4);
        student2.addMark(4);
        student2.addMark(3);

        student3.addMark(5);
        student3.addMark(5);
        student3.addMark(2);

        Group group1 = new Group("g1");
        group1.addStudent(student1);
        group1.addStudent(student2);
        group1.addStudent(student3);

        System.out.println("Вывод1 getAverageMark_double");
        System.out.println(student1.getName() + " " + student1.getAverageMarkDouble());
        System.out.println(student2.getName() + " " + student2.getAverageMarkDouble());
        System.out.println(student3.getName() + " " + student3.getAverageMarkDouble());
        System.out.println();

        System.out.println("Вывод1 getAverageMark_int");
        System.out.println(student1.getName() + " " + student1.getAverageMarkInt());
        System.out.println(student2.getName() + " " + student2.getAverageMarkInt());
        System.out.println(student3.getName() + " " + student3.getAverageMarkInt());
        System.out.println();

        //попробуем просто вывести по имени
        System.out.println("Вывод2 по наличию 'Гарик'");
        group1.getStudents().stream()
                .filter(student -> student.getName().contains("Гарик"))
                .forEach(student -> System.out.println(student.getName()));
        System.out.println();

        //попробуем вывести сортировку
        System.out.println("Вывод3 попробуем вывести БЕЗ сортировки: средние оценки");
        for (Student student : group1.getStudents()) {
            System.out.println(student.getAverageMarkInt());
        }
        System.out.println();

        System.out.println("Вывод3 попробуем вывести С сортировкой: средние оценки (через студентов)");
        List<Student> sortedStudents = group1.getStudents().stream()
                .sorted(Comparator.comparingInt(Student::getAverageMarkInt))
                .toList();

        for (Student sortedStudent : sortedStudents) {
            System.out.println(sortedStudent.getAverageMarkInt());
        }
        System.out.println();

        //попробуем сортировку по фамилии студента
        Map<String, Integer> studentsNameAndMark = new HashMap<>();
        group1.getStudents().forEach(student ->
                studentsNameAndMark.put(student.getName(), student.getAverageMarkInt()));

        List<Map.Entry<String, Integer>> sorted  = studentsNameAndMark.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toList());

        for (Map.Entry<String, Integer> stringIntegerEntry : sorted) {
            System.out.println(stringIntegerEntry.getKey() + " " + stringIntegerEntry.getValue());
        }

    }

}
