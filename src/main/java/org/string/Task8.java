package org.string;

import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String str = console.nextLine();
        int n = console.nextInt();
        int count = 0;
        char[] chArray= str.toCharArray();

        for (int i = 0; i < chArray.length; i++) {
            if (i == 0) {
                chArray[i] = '#';
            } else if (count == n) {
                chArray[i] = '#';
                count = 0;
            }
            count++;
        }
        System.out.println(String.valueOf(chArray));
    }
}
// можно сделать проще - учитывать четность/нечетность, код сократится
