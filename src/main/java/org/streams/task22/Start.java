package org.streams.task22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Start {

    public static void main(String[] args) {
        // Создаем список для хранения строк таблицы
        List<Map<String, String>> table = new ArrayList<>();

        Map<String, String> row1 = new HashMap<>();
        row1.put("Имя", "Кирилл");
        row1.put("Возраст", "26");
        row1.put("Должность", "Инженер");
        row1.put("Зарплата", "150000 руб");
        table.add(row1);

        Map<String, String> row2 = new HashMap<>();
        row2.put("Имя", "Виталий");
        row2.put("Возраст", "28");
        row2.put("Должность", "Директор");
        row2.put("Зарплата", "2000$");
        table.add(row2);

        Map<String, String> row3 = new HashMap<>();
        row3.put("Имя", "Александр");
        row3.put("Возраст", "31");
        row3.put("Должность", "Бухгалтер");
        row3.put("Зарплата", "50000 руб");
        table.add(row3);

        Map<String, String> row4 = new HashMap<>();
        row4.put("Имя", "Дементий");
        row4.put("Возраст", "35");
        row4.put("Должность", "Старший инженер");
        row4.put("Зарплата", "1500$");
        table.add(row4);

        Map<String, String> row5 = new HashMap<>();
        row5.put("Имя", "Емельян");
        row5.put("Возраст", "28");
        row5.put("Должность", "Программист");
        row5.put("Зарплата", "256000 руб");
        table.add(row5);

        Map<String, String> row6 = new HashMap<>();
        row6.put("Имя", "Фёдор");
        row6.put("Возраст", "20");
        row6.put("Должность", "Сварщик");
        row6.put("Зарплата", "35000 руб");
        table.add(row6);

        for (Map<String, String> stringStringMap : table) {
            System.out.println(stringStringMap);
        }
        System.out.println();

        //вывести имена всех сотрудников, младше 30;
        table.stream()
                .filter(x -> Integer.parseInt(x.get("Возраст")) < 30)
                .map(x -> x.get("Имя"))
                .forEach(System.out::println);
        System.out.println();

        //вывести имена всех сотрудников, получающих зарплату в рублях;
        table.stream()
                .filter(x -> x.get("Зарплата").contains("руб"))
                .forEach(System.out::println);
        System.out.println();

        // вычислить средний возраст всех сотрудников   //average в данном случае и есть терминальная операция (финальная), orElse не финальная, а скорее как возможность исключения
        //TODO как еще кроме orElse можно завершить? -
        double averageAge = table.stream()
                .mapToInt(x -> Integer.parseInt(x.get("Возраст")))
                .average()
                .orElse(0);             // если нет сотрудников, возвращаем 0
        System.out.println(averageAge);
        System.out.println();

        // найти имя и возраст сотрудника с самой большой зарплатой
        Map<String, String> highestSalaryEmployee = table.stream()
                .max((e1, e2) -> {
                    int salary1 = extractSalary(e1.get("Зарплата"));
                    int salary2 = extractSalary(e2.get("Зарплата"));
                    return Integer.compare(salary1, salary2);
                })
                .orElse(null); // если нет сотрудников, возвращаем null

        if (highestSalaryEmployee != null) {
            String name = highestSalaryEmployee.get("Имя");
            String age = highestSalaryEmployee.get("Возраст");
            System.out.println("Сотрудник с самой высокой зарплатой: " + name + ", Возраст: " + age);
        }
    }

    // Метод для извлечения числовой части зарплаты
    private static int extractSalary(String salary) {
        return Integer.parseInt(salary.replaceAll("[^0-9]", "")); // Удаляем символы, кроме цифр
    }

}
