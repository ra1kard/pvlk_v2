package org.arrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task16_2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(List.of(
                "Toyota 10", "Nissan 3", "BMW 7",
                "Toyota 4", "Nissan 7", "BMW 1", "Reno 17"));
        Scanner console = new Scanner(System.in);
        String strUser = console.nextLine();
        int rsl = 0;

        for (String s : list) {
            String[] arrayString = s.split(" ");
            if (arrayString[0].equalsIgnoreCase(strUser)) {
                rsl += Integer.parseInt(arrayString[1]);
            }
        }

        System.out.println(rsl);
    }
}
