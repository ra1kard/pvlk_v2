package org.multithreading.task8_3;

import java.io.Serializable;
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
            System.out.println();
            System.out.println("ЧТОЖЕ ПРИСТУПАЮ К ВОПРОСУ НУМЕРО " + (i + 1));
            questions.get(i).printTextQuestion(i + 1);
            questions.get(i).printAnswers();

            Scanner sc = new Scanner(System.in);
            int indexChooseAnswer = askQuestion(10, sc);

            // TODO: анализруем, что получено в askQuestion
            // Если за отведённое время ответа дано не было - ответ не засчитывается

            // получим если 0 (что означает, что не выбрали за отведенное время) - то ответ не засчитываем
            // и соответственно нет нужды что-то передавать в selectAnswer

            while (indexChooseAnswer != 0 && (indexChooseAnswer < 1 || indexChooseAnswer > 3)) {    // если получили не 0 и вне диапазона - повтор
                System.out.println("Введите диапазон от 1 до 3");
                indexChooseAnswer = askQuestion(5, sc);
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

    // TODO: повыводить futureAnswer и тп - НЕ ОТРАБАТЫВАЕТ ОДИН КЕЙС - перепроверь выводом и ес че отправь Паше

    public static Integer askQuestion(int timeoutSeconds, Scanner sc) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        Future<? extends Serializable> f = exec.submit(() -> {
            //Scanner sc = new Scanner(System.in);
            try {
                //return sc.nextInt();
                return sc.nextLine();
            } catch (NoSuchElementException e) {
                return 0;
            }
        });

        int answer = 0;
        try {
            // ждем не более timeoutSeconds
            answer = Integer.parseInt((String) f.get(timeoutSeconds, TimeUnit.SECONDS));
        } catch (TimeoutException e) {
            System.out.println("\n--- Время вышло! ---");
            f.cancel(true);
        } catch (InterruptedException | ExecutionException e) {
            // тут можно залогировать, если надо
        } finally {
            exec.shutdownNow();
        }
        return answer;
    }

}
