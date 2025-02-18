package org.collection.example1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Start9 {

    public static void main(String[] args) {
        //List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        ArrayList<String> list = new ArrayList<>(List.of("a", "b", "c", "d", "e", "f"));
        for (String s : list) {
            if (s.equals("b"))
                list.remove(s); // Неверно!
        }

        for (String s : list) {
            System.out.println(s);
        }
    }

}
