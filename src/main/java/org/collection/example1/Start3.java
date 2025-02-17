package org.collection.example1;

import java.util.HashMap;
import java.util.Map;

public class Start3 {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Apple", 3); // Значение для ключа "Apple" будет обновлено

        for (String s : map.keySet()) {
            System.out.println(s + " " + map.get(s));
        }
    }

}
