package org.multithreading.task2_1;

public class MyThread implements Runnable {
    public static int counter = 5000;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.printf("%s started... \n", threadName);

        while (true) {
            //synchronized (MyThread.class) { // Блок синхронизации для обеспечения корректного доступа к переменной counter
                if (counter <= 0 || counter >= 10000) {
                    if (threadName.equals("MyThreadX") && counter >= 10000) {
                        System.out.printf("%s wins! Counter reached %d\n", threadName, counter);
                    } else if (threadName.equals("MyThreadY") && counter <= 0) {
                        System.out.printf("%s wins! Counter reached %d\n", threadName, counter);
                    }
                    break;
                }

                // В зависимости от имени потока изменяем счетчик соответственно
                if (threadName.equals("MyThreadX")) {
                    counter++; // первый поток увеличивает значение
                    System.out.println(threadName + " я увеличил только что ⬆\uFE0F " + counter);
                } else if (threadName.equals("MyThreadY")){
                    counter--; // второй поток уменьшает значение
                    System.out.println(threadName + " я ⬇\uFE0F уменьшил только что " + counter);
                }
            //}

            /*// Немного "замедляем" выполнение, чтобы дать возможность переключаться потокам
            // эта задержка не обязательна, но помогает наблюдать изменения счетчика
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(threadName + " was interrupted");
            }*/
        }
        System.out.printf("%s finished... \n", threadName);

    }

}
