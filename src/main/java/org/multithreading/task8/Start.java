package org.multithreading.task8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Start {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();
        List<String> myAnswers1 = new ArrayList<>();
        List<String> myAnswers2 = new ArrayList<>();
        List<String> myAnswers3 = new ArrayList<>();

        myAnswers1.add("Сара");
        myAnswers1.add("Зара");
        myAnswers1.add("Нала");
        myAnswers2.add("18");
        myAnswers2.add("21");
        myAnswers2.add("23");
        myAnswers3.add("1.0");
        myAnswers3.add("3.0");
        myAnswers3.add("10.0");

        Question question1 = new Question("Персонаж в король лев?", 1, myAnswers1, 3);
        Question question2 = new Question("Водку в каком возрасте можно купить?", 2, myAnswers2, 1);
        Question question3 = new Question("Средний уровень холестирина в крови?", 3, myAnswers3, 2);
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);

        int sumBalls = 0;
        for (int i = 0; i < questions.size(); i++) {
            questions.get(i).printTextQuestion(i + 1);
            questions.get(i).printAnswers();
            sumBalls += questions.get(i).selectAnswer(correctAnswer());
            System.out.println("ВСЕГО баллов: " + sumBalls);
        }
    }

    // Должна быть проверка на корректность переданного значения.
    public static int correctAnswer() {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите диапазон от 1 до 3");
        int choose = console.nextInt();
        while (choose < 1 || choose > 3) {
            System.out.println("Введите диапазон еще раз от 1 до 3");
            choose = console.nextInt();
        }
        return choose;
    }

}
