package org.multithreading.task5_2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Start {
    public static int counterX = 22;
    public static int counterY = 22;

    public static void main(String[] args) {
        System.out.println("Main thread started….");
        List<MultiThreading> multiThreadingList = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(3);     //пул из 3 потоков

        for (int i = 0; i < 1; i++) {
            final int taskId = i;
            int finalI = i;
            executor.submit(() -> {     //касса1
                System.out.println("Task + " + taskId + " is running on thread " + Thread.currentThread().getName());
                if (counterX <= 149600) {
                    counterX++;
                    System.out.println(Thread.currentThread().getName() + ": counterX is " + counterX);
                }
            });
        }

        //тут 1 человек в очереди, готов пропикивать 1 раз counter++
        //если добавим внутри еще whyle цикл до 150к, то буд-то 1 человек будет давать кассиру что-то, пикать 150к
        //мы можем добавить в очередь (for) еще людей
        for (int i = 0; i < 1; i++) {
            final int taskId = i;
            int finalI = i;
            executor.submit(() -> {     //касса2
                System.out.println("Task + " + taskId + " is running on thread " + Thread.currentThread().getName());
                if (counterY <= 149600) {
                    counterY++;
                    System.out.println(Thread.currentThread().getName() + ": counterX is " + counterX);
                }
            });
        }

        System.out.println("Main thread finished...");
    }

}
