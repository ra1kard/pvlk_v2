package org.collection.example1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Start10 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.equals("b"))
                it.remove();  // Удаляем через итератор
        }

        for (String s : list) {
            System.out.println(s);
        }
    }

}
