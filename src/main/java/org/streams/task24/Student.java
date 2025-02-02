package org.streams.task24;

import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Integer> marks = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    public void addMark(int mark) {
        marks.add(mark);
    }

    public double getAverageMarkDouble() {
        return marks.stream()
                .mapToInt(i -> i)
                .average()
                .orElse(0);
    }

    public int getAverageMarkInt() {
        return (int) marks.stream()
                .mapToInt(i -> i)
                .average()
                .orElse(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }

}
