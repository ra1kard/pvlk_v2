package org.multithreading.task3_2;

import java.util.Scanner;

public class Start {

    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        Scanner console = new Scanner(System.in);
        int count = 100;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = count++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Введите число, наличие которого необходимо проверить в массиве: ");
        int searchValue = console.nextInt();

        RowSearchThread rowSearchThreadFirst = new RowSearchThread(arr[0], searchValue, 0);
        RowSearchThread rowSearchThreadSecond = new RowSearchThread(arr[1], searchValue, 1);
        RowSearchThread rowSearchThreadThird = new RowSearchThread(arr[2], searchValue, 2);

        rowSearchThreadFirst.start();
        rowSearchThreadSecond.start();
        rowSearchThreadThird.start();

    }

}
