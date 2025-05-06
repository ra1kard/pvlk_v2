package org.multithreading.task6_2;

public class MultiThreading extends Thread {
    private Expression expression;
    private String strResExp;
    private int intRes;

    MultiThreading(String name, Expression expression) {
        super(name);
        this.expression = expression;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.printf("%s started... \n", threadName);

        if (expression.getExpressionType() == expressionType.ADDITION) {
            intRes = expression.getFirstNumber() + expression.getSecondNumber();
            strResExp = expression.getFirstNumber() + " + " + expression.getSecondNumber() + " = " + intRes;
        } else if (expression.getExpressionType() == expressionType.MULTIPLICATION) {
            intRes = expression.getFirstNumber() * expression.getSecondNumber();
            strResExp = expression.getFirstNumber() + " * " + expression.getSecondNumber() + " = " + intRes;
        } else {
            intRes = expression.getFirstNumber() / expression.getSecondNumber();
            strResExp = expression.getFirstNumber() + " / " + expression.getSecondNumber() + " = " + intRes;
        }
        System.out.println(strResExp);

        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }

}
