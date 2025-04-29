package org.multithreading.task6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Start {

    public static void main(String[] args) {
        System.out.println("Main thread started….");
        List<MultiThreading> multiThreadingList = new ArrayList<>();

        System.out.println("Всего посчитаем 3 выражения");
        Scanner console = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("- - - - - Выражение №" + (i+1) + " из 3- - - - - ");

            System.out.println("Введите первое число выражения:");
            int x1 = console.nextInt();

            System.out.println("Введите второе число выражения:");
            int x2 = console.nextInt();

            System.out.println("Выберите тип операции над этими двумя числами.");
            System.out.println("В числовом виде 1 2 3: ADDITION, MULTIPLICATION, DIVISION");
            expressionType exp;
            while (true) {
                int expInt = console.nextInt();
                if (expInt == 1) {
                    exp = expressionType.ADDITION;
                    break;
                } else if (expInt == 2) {
                    exp = expressionType.MULTIPLICATION;
                    break;
                } else if (expInt == 3) {
                    exp = expressionType.DIVISION;
                    break;
                } else {
                    System.out.println("Выберите число в диапазоне 1-3");
                }
            }
            MultiThreading thread = new MultiThreading("thread " + (i+1), new Expression(x1, x2, exp));
            multiThreadingList.add(thread);
        }

        for (MultiThreading threading : multiThreadingList) {
            threading.start();
            try {
                threading.join();
            } catch (InterruptedException e) {
                System.out.println("Main thread was interrupted");
            }
        }

        System.out.println("Main thread finished...");
    }

}
