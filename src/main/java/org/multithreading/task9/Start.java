package org.multithreading.task9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Start {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        RacingCar mazda3 = new RacingCar("mazda_", "m3", "3", 200, 5, 0);
        RacingCar mazda4 = new RacingCar("mazda_", "m4", "4", 220, 7, 0);
        RacingCar mazda5 = new RacingCar("mazda_", "m5", "5", 240, 9, 0);
        RacingCar mazda6 = new RacingCar("mazda_", "m6", "6", 260, 15, 0);
        RacingCar mazda7 = new RacingCar("mazda_", "m6", "6", 300, 20, 0);

        List<RacingCar> cars = new ArrayList<>();
        cars.add(mazda3);
        cars.add(mazda4);
        cars.add(mazda5);
        cars.add(mazda6);
        cars.add(mazda7);

        for (int i = 0; i <= 4; i++) {
            RacingCar car = cars.get(i);
            executor.submit(() -> {
                System.out.println("Task " + car + " is running on thread " + Thread.currentThread().getName());
                car.raceStart();
            });
        }

        System.out.println(executor.);



        /*for (RacingCar car : cars) {
            System.out.println(car.getMarkAuto() + " " + car.getModelAuto() + " текущая скорость: " + car.getCurrentSpeed());
        }

        for (RacingCar car : cars) {
            car.raceStart();
        }

        System.out.println();
        for (RacingCar car : cars) {
            System.out.println(car.getMarkAuto() + " " + car.getModelAuto() + " текущая скорость: " + car.getCurrentSpeed());
        }
        */
    }

}
