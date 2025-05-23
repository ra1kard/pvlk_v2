package org.example;

public class Task41 {
    public static void main(String[] args) {
        int number = 112;
        int count = 0;
        while (number > 0) {                //учитываем целое число
            int digit = number % 10;        //получаем остаток
            System.out.println(digit);      //и выводим остаток
            number = number / 10;           //получаем целое число, без остатка

            count++;                        //доп счетчик чтобы посчитать кол-во цифр в числе
        }

        System.out.println("ск цифр две или одна или три? = " + count);
    }
}

/*
1.  12.3            = 123 % 10
    3               = 123 % 10
    печатаем 3      //
    12.3            = 123 / 10
    12              = 123 / 10          сначала целое число 12 = 12 раз по 10

2.  1.2             = 12 % 10
    2               = 12 % 10
    печатаем 2      //
    12              = 12 / 10
    1               = 12 / 10           затем целое число 1 = 1 раз по 10


3.  0.1             = 1 % 10
    1               = 1 % 10
    печатаем 1      //
    0.1             = 1 / 10
    0               = 1 / 10            затем целое число 0 = 0 раз по 10

Ответы:
1) вывод остатка 3, 2, 1
2) условие выхода из цикла = после 3-ей итерации number, цел число, не больше нуля
3) у нас изнач number > 0 и в ходе вып тела цикла, число ост уменьшается, логично
4) посредством этого выражения мы каждый раз получаем целое число от деления

 */
