package org.collection.example1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Start12 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        list.removeIf(s -> s.equals("b"));
    }

}
