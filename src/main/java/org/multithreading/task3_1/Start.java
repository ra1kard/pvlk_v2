package org.multithreading.task3_1;

import java.util.Scanner;

/*public class Start {
    public static void main(String args) {
        int  twoDimArray = {
                {5, 7, 3, 17},
                {7, 0, 1, 12},
                {8, 1, 2, 3}
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число, которое необходимо найти: ");
        int searchValue = scanner.nextInt();
        scanner.close();

        // Для хранения созданных потоков используем массив потоков
        Thread threads = new ThreadtwoDimArray.length;

        // Для каждой строки создаем поток, который будет выполнять поиск
        for (int i = 0; i < twoDimArray.length; i++) {
            threadsi = new RowSearchThread(i, twoDimArrayi, searchValue);
            threadsi.start();
        }

        // Ожидаем завершения работы всех потоков
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println(t.getName() + " прерван");
            }
        }

        System.out.println("Main thread finished...");
    }
}*/

