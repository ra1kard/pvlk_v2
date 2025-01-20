package org.streams.task24;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Group {
    private String name;
    ArrayList<Student> students = new ArrayList<>();

    Group(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addMark(int mark, Student student) {
        student.addMark(mark);
    }

    /*public ArrayList<Student> getListStudentsBvAverage() {
        students.forEach(student -> {
            double average = student.getMarks().stream()
                    .mapToInt(m -> m)
                    .average()
                    .orElse(0);
        });
    }*/

    /*public ArrayList<Student> getListStudentsBvAverage() {
        ArrayList<Student> newListSt = (ArrayList<Student>) students.stream()
                .map()
                .collect(Collectors.toList());
        return newListSt;
    }*/



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

}
