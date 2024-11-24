package org.method;

import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String str = console.nextLine();
        System.out.println(deleteNumbers(str));
    }

    public static String deleteNumbers(String str) {
        char[] chars = str.toCharArray();
        String strNew = "";
        for (char ch : chars) {
            if (!((ch >= 48) && (ch <= 57))) {   //если не цифра, добавляем в строку
                if (strNew.isEmpty()) {
                    strNew = String.valueOf(ch);
                } else {
                    strNew += ch;
                }
            }
        }
        strNew = strNew.replace("  ", " ");
        strNew = strNew.trim();
        return strNew;
    }
}
