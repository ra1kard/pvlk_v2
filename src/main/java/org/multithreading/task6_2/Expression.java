package org.multithreading.task6_2;

public class Expression {
    private int firstNumber;
    private int secondNumber;
    private expressionType expressionType;

    Expression(int firstNumber, int secondNumber, expressionType expressionType) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.expressionType = expressionType;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public expressionType getExpressionType() {
        return expressionType;
    }

}
