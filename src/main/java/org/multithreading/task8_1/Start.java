package org.multithreading.task8_1;

import java.util.*;
import java.util.concurrent.*;

public class Start {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();
        List<String> myAnswers1 = new ArrayList<>();
        List<String> myAnswers2 = new ArrayList<>();
        List<String> myAnswers3 = new ArrayList<>();

        myAnswers1.add("Сара");
        myAnswers1.add("Зара");
        myAnswers1.add("Нала");
        myAnswers2.add("18");
        myAnswers2.add("21");
        myAnswers2.add("23");
        myAnswers3.add("1.0");
        myAnswers3.add("3.0");
        myAnswers3.add("10.0");

        Question question1 = new Question("Персонаж в король лев?", 1, myAnswers1, 3);
        Question question2 = new Question("Водку в каком возрасте можно купить?", 2, myAnswers2, 1);
        Question question3 = new Question("Средний уровень холестирина в крови?", 3, myAnswers3, 2);
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);

        int sumBalls = 0;
        for (int i = 0; i < questions.size(); i++) {
            questions.get(i).printTextQuestion(i + 1);
            questions.get(i).printAnswers();

            //int indexChooseAnswer = console.nextInt();
            int indexChooseAnswer = askQuestion(15);

            // Если за отведённое время ответа дано не было - ответ не засчитывается
            // получим если null
            // и selectAnswer

            sumBalls += questions.get(i).selectAnswer(indexChooseAnswer);
            System.out.println("ВСЕГО баллов: " + sumBalls);
            /*try {
                Thread.sleep(2000);
            } catch(InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }*/
        }
    }

    public static Integer askQuestion(int timeoutSeconds) {
        Scanner console = new Scanner(System.in);
        ExecutorService exec = Executors.newSingleThreadExecutor();

        // Запускаем поток, который читает строку из консоли
        Future<Integer> futureAnswer = exec.submit(() -> {
            return console.nextInt();   //ждем, если не вернулось done 15 сек
        });

        // Настраиваем таймер, который через timeoutSeconds секунд отменит future, если тот ещё не завершился
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!futureAnswer.isDone()) {                      // тут мб два состояния - ввели или не ввели (если не ввели - ждем, смотря что раньше произойдет - мы введем или 15 сек пройдут)
                    System.out.println("\n--- Время вышло! ---");
                    futureAnswer.cancel(true);  // попытаемся прервать
                }
            }
        }, timeoutSeconds * 1000L);

        Integer answer = null;
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
