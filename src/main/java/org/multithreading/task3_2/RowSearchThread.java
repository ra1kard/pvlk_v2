package org.multithreading.task3_2;

public class RowSearchThread extends Thread {
    private int[] row;
    private int searchValue;
    private int rowNumber;
    private int columnNumber;

    RowSearchThread(int[] row, int searchValue, int rowNumber) {
        super("SearchThreadRow" + rowNumber);
        this.row = row;
        this.searchValue = searchValue;
        this.rowNumber = rowNumber;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.printf("%s started... \n", threadName);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }

        for (int i : row) {
            System.out.println(i + " : " + rowNumber);
        }

        //ищем по условию
        boolean result = false;
        for (int i = 0; i < row.length; i++) {
            if (row[i] == searchValue) {
                columnNumber = i;
                result = true;
            }
        }

        if (result) {
            //System.out.println("Search successful");
            System.out.println("Элемент " + searchValue
                    + " находится в ячейке [" + rowNumber + "][" + columnNumber + "]");
        } else {
            //System.out.println("Search failed");
            System.out.println("В строке " + rowNumber + " нет элемента, равного " + searchValue);
        }

        System.out.printf("%s finished... \n", threadName);
    }

}
