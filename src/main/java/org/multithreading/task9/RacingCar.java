package org.multithreading.task9;

public class RacingCar {
    private final String markAuto;          //марка
    private final String modelAuto;         //модель
    private final String numberAuto;        //номер
    private final int maxSpeed;                   //макс скорость
    private final int speedBoostForOneSecond;     //на сколько увеличивается скорость за одну секунду
    private int currentSpeed;                     //текущ скорость

    RacingCar(String markAuto, String modelAuto, String numberAuto, int maxSpeed, int speedBoostForOneSecond, int currentSpeed) {
        this.markAuto = markAuto;
        this.modelAuto = modelAuto;
        this.numberAuto = numberAuto;
        this.maxSpeed = maxSpeed;
        this.speedBoostForOneSecond = speedBoostForOneSecond;
        this.currentSpeed = currentSpeed;
    }

    void raceStart() {
        currentSpeed = 50;
    }

    @Override
    public String toString() {
        String rsl = this.markAuto + this.modelAuto + " currentSpeed: " + currentSpeed;
        return rsl;
    }

    public String getMarkAuto() {
        return markAuto;
    }

    public String getModelAuto() {
        return modelAuto;
    }

    public String getNumberAuto() {
        return numberAuto;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getSpeedBoostForOneSecond() {
        return speedBoostForOneSecond;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

}
