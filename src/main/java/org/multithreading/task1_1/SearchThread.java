package org.multithreading.task1_1;

import java.util.ArrayList;
import java.util.Optional;

public class SearchThread extends Thread {
    public enum Operation { FINDMAX, FINDMIN }
    private final ArrayList<Integer> list;
    private final Operation op;
    private Optional<Integer> result = Optional.empty();

    public SearchThread(String name, ArrayList<Integer> list, Operation op) {
        super(name);
        this.list = list;
        this.op = op;
    }

    @Override
    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        // Имитируем выполнение работы
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }
        // Выполняем нужное вычисление:
        if(op == Operation.FINDMAX) {
            result = list.stream().max(Integer::compareTo);
            result.ifPresent(val -> System.out.println("Find max: " + val));
        }
        else if(op == Operation.FINDMIN) {
            result = list.stream().min(Integer::compareTo);
            result.ifPresent(val -> System.out.println("Find min: " + val));
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }

    public Optional<Integer> getResult() {
        return result;
    }

}
