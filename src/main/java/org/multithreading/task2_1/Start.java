package org.multithreading.task2_1;

public class Start {

    public static void main(String[] args) {
        System.out.println("Main thread started...");

        // Создаем два отдельных потока, каждый получает экземпляр Runnable
        Thread myThreadX = new Thread(new MyThread(), "MyThreadX");
        Thread myThreadY = new Thread(new MyThread(), "MyThreadY");

        myThreadX.start();
        myThreadY.start();

        // Ждем, пока оба потока завершатся, чтобы основной поток продолжил выполнение
        try {
            myThreadX.join();
            myThreadY.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted");
        }

        System.out.println("Main thread finished...");
    }
}

// запусти и смотри за результатом! (без synchronized)

// int temp = counter   ПРЕРВАН (без synchronized)
// counter = temp - 1   (или +1, важно просто понимать, так работает counter, есть возможность куда вклиниться)

// int  temp = 2995
// int  temp = 2994
// int  temp = 2993
// int  temp = 2992
// в этот момент был ПРЕРВАН поток уменьшения и запустился поток увеличения:
// он догнал значение до 3934
// а потом очередь перешла к потоку уменьшения
// и он продолжил с 2992 !!!

// вот тебе и гонка потоков
