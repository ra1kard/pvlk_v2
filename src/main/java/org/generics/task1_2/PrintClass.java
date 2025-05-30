package org.generics.task1_2;

import java.util.ArrayList;
import java.util.List;

public class PrintClass <T> {
    ArrayList<T> values;       //поле приватное и не имеет сеттера геттера

    //сама коллекция должна инициироваться в конструкторе
    PrintClass() {
        values = new ArrayList (List.of("Раз", "Два", "Четыре", "Восемь"));
    }

    //Вывести все значения из списка. Каждое новое значение выводится с новой строки
    public void printAll() {
        for (T value : values) {
            System.out.println(value);
        }
        System.out.println();
    }

    //Вывести значение из списка под указанным номером
    public void print(int a) {
        System.out.println(values.get(a));
    }

}
