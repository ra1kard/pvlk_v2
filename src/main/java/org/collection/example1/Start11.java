package org.collection.example1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Start11 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("b")) {
                list.remove(i);
                i--;  // корректировка индекса, чтобы не пропустить следующий элемент
            }
        }

        for (String s : list) {
            System.out.println(s);
        }
    }

}
