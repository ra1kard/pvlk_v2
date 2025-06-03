package org.multithreading.task8_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question {
    Scanner console = new Scanner(System.in);
    private String text;                                // текст вопроса
    private int numberPoint;                            // кол-во баллов за верный ответ
    private List<String> answers = new ArrayList<>();   // список ответов на вопрос
    private int indexRightAnswer;                       // номер правильного ответа

    Question(String text, int numberPoint, List<String> answers, int indexRightAnswer) {
        this.text = text;
        this.numberPoint = numberPoint;
        this.answers = answers;
        this.indexRightAnswer = indexRightAnswer;
    }

    void printTextQuestion(int countNumberQuestion) {   // метод вывода вопроса
        // Перед самым текстом вопроса должен выводиться порядковый номер,
        // Который передается в метод как параметр
        System.out.println();
        System.out.println("---Вопрос №" + countNumberQuestion + "---");
        System.out.println(this.text);
    }

    void printAnswers() {                               // метод вывода списка ответов
        System.out.println("---Список трёх вариантов ответа---");
        for (String answer : answers) {
            System.out.println(answer);
        }
        System.out.println("---Введите число с номером ответа (1-3)---");
    }

    int selectAnswer(int indexChooseAnswer) {             //метод выбора номера ответа
        // Метод возвращает количество баллов за выбранный вариант ответа.
        if (indexChooseAnswer == indexRightAnswer) {
            System.out.println("Верно, потрясающе! Кол-во баллов за ответ: " + numberPoint);
            return numberPoint;
        } else {
            System.out.println("Неверно! Кол-во баллов за ответ: 0");
            return 0;
        }
    }

}
