package org.multithreading.task8_timer;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

public class TimedQuiz {

    public static void main(String[] args) {
        String q1 = "Сколько будет 2 + 2?";
        String answer1 = askQuestion(q1, 15);
        if (answer1 != null) {
            System.out.println("Ваш ответ: " + answer1);
        } else {
            System.out.println("Время вышло! Переходим к следующему вопросу.");
        }

        // Можно задать ещё вопросов...
        System.exit(0);
    }

    /*
     * Задаёт вопрос в консоль, ждёт ввода до timeoutSeconds секунд.
     * Если пользователь успел ввести строку — возвращаем её,
     * иначе — возвращаем null.
     */
    public static String askQuestion(String question, int timeoutSeconds) {
        Scanner console = new Scanner(System.in);
        ExecutorService exec = Executors.newSingleThreadExecutor();

        // Запускаем поток, который читает строку из консоли
        Future<String> futureAnswer = exec.submit(() -> {
            System.out.print(question + " ");
            return console.nextLine();
        });

        // Настраиваем таймер, который через timeoutSeconds секунд отменит future, если тот ещё не завершился
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!futureAnswer.isDone()) {
                    System.out.println("\n--- Время вышло! ---");
                    futureAnswer.cancel(true);  // попытаемся прервать
                }
            }
        }, timeoutSeconds * 1000L);

        String answer = null;
        try {
            // Блокируемся пока пользователь не введёт ответ или пока future не будет отменён
            answer = futureAnswer.get();
        } catch (CancellationException | InterruptedException e) {
            // Время вышло или нас прервали
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Очищаем ресурсы
            timer.cancel();
            exec.shutdownNow();
        }

        return answer;
    }

}
