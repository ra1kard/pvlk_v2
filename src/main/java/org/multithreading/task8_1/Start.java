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

            int indexChooseAnswer = askQuestion(10);

            // TODO: анализруем, что получено в askQuestion
            // Если за отведённое время ответа дано не было - ответ не засчитывается

            // получим если 0 (что означает, что не выбрали за отведенное время) - то ответ не засчитываем
            // и соответственно нет нужды что-то передавать в selectAnswer

            while (indexChooseAnswer != 0 && (indexChooseAnswer < 1 || indexChooseAnswer > 3)) {    // если получили не 0 и вне диапазона - повтор
                System.out.println("Введите диапазон от 1 до 3");
                indexChooseAnswer = askQuestion(5);
            }

            if (indexChooseAnswer == 0) {
                System.out.println("ВСЕГО баллов: " + sumBalls);
            } else {
                // если selectAnswer заполнен
                sumBalls += questions.get(i).selectAnswer(indexChooseAnswer);
                System.out.println("ВСЕГО баллов: " + sumBalls);
            }
        }
    }

    /*public static int correctAnswer() {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите диапазон от 1 до 3");
        int choose = console.nextInt();
        while (choose < 1 || choose > 3) {
            System.out.println("Введите диапазон еще раз от 1 до 3");
            choose = console.nextInt();
        }
        return choose;
    }*/

    // TODO: повыводить futureAnswer и тп - НЕ ОТРАБАТЫВАЕТ ОДИН КЕЙС

    public static Integer askQuestion(int timeoutSeconds) {
        Scanner console = new Scanner(System.in);
        ExecutorService exec = Executors.newSingleThreadExecutor();

        Future<Integer> futureAnswer = exec.submit(() -> {  // Запускаем поток, который читает строку из консоли
            return console.nextInt();                       // ждем, если не вернулось done, в течение 15 сек
        });

        Timer timer = new Timer();  // Настраиваем таймер, который через timeoutSeconds секунд отменит future, если тот ещё не завершился
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!futureAnswer.isDone()) {                      // тут мб два состояния - ввели или не ввели (если не ввели - ждем, смотря что раньше произойдет - мы введем и это условие будет неактуально или 15 сек пройдут и условие будет выполнено)
                    System.out.println("\n--- Время вышло! ---");
                    futureAnswer.cancel(true);  // попытаемся прервать
                }
            }
        }, timeoutSeconds * 1000L);

        Integer answer = 0;
        try {
            answer = futureAnswer.get();    // Блокируемся пока пользователь не введёт ответ или пока future не будет отменён
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

