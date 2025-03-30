package org.multithreading.task2_1;

public class Start {

    public static void main(String args[]) {
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

//
// int temp = counter   ПРЕРВАН (без синхронайзд)
// counter = temp - 1

// int  temp = 2992
// в этот момент был прерван поток уменьш и запустился поток ув
// он догнал значение до 3934
// а потом очередь перешла к потоку уменьшения
// и он продолжил с того