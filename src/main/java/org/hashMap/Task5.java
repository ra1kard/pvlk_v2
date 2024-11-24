package org.hashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        Scanner console = new Scanner(System.in);
        String str = console.nextLine();
        String[] arrayString = str.split(" ");

        map.put(arrayString[0], arrayString[1]);
        System.out.println(arrayString[0] + " живет в городе " + arrayString[1]);

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
//вариант 1
