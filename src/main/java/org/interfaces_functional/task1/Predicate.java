package org.interfaces_functional.task1;

import java.util.ArrayList;

public interface Predicate<T> {
    boolean test(T t);

    Integer test(int number);

    Integer test(ArrayList<Integer> list);

}
