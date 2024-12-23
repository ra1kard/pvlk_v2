package org.interfaces_functional.task6;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Start {

    public static void main(String[] args) {
        Function<ArrayList<String>, String> findBiggestString = strings -> {
            String maxString = "";
            for (String string : strings) {
                if (string.length() > maxString.length()) {
                    maxString = string;
                }
            }
            return maxString;
        };

        ArrayList<String> stringsList = new ArrayList<>(List.of("Первый", "Второй", "Длинное словечко", "Окончание"));
        System.out.println(findBiggestString.apply(stringsList));
    }

    //TODO: обсудить:
    // Лямбда-выражение в Java — это блок кода, запоминающий контекст вокруг себя в момент создания.
    // По сути, это:
    // - анонимный (без имени) класс или метод,
    // - который можно передать в качестве аргумента или присвоить переменной.
    // Простыми словами:
    // - лямбда представляет набор инструкций,
    // - которые можно выделить в отдельную переменную
    // - и затем многократно вызвать в различных местах программы.

}
