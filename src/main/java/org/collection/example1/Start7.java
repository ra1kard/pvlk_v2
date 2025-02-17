package org.collection.example1;

import java.util.HashMap;
import java.util.Map;

public class Start7 {

    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Apple", 1);
        hashMap.put("Banana", 2);
        System.out.println(hashMap.get("Apple")); // Вывод: 1

        System.out.println();
        for (String s : hashMap.keySet()) {
            System.out.println(s + " : " + hashMap.get(s));
        }
    }

}
