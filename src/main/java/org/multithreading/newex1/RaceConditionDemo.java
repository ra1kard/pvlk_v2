package org.multithreading.newex1;

public class RaceConditionDemo {
    private int counter = 0;

    public void increment() {
        // Операция ++ не является атомарной!
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    public static void main(String args) throws InterruptedException {
        RaceConditionDemo demo = new RaceConditionDemo();
        // Создадим 2 потока, каждый увеличивает счетчик на 1000 раз
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                demo.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                demo.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // Ожидаем, что counter будет равен 2000,
        // но благодаря гонке потоков может получиться другое число!
        System.out.println("Final counter: " + demo.getCounter());
    }

}
