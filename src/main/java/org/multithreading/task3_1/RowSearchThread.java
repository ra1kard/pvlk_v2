package org.multithreading.task3_1;

public class RowSearchThread extends Thread {
    private int rowIndex;
    // Поле для хранения строки должно быть массивом целых чисел,
    // а не одним числом
    private int[] row;
    private int target;

    // В конструкторе передаётся конкретная строка (одномерный массив),
    // а не двумерный массив
    public RowSearchThread(int rowIndex, int[] row, int target) {
        super("SearchThreadrow" + rowIndex);
        this.rowIndex = rowIndex;
        this.row = row;
        this.target = target;
    }

    @Override
    public void run() {
        boolean found = false;
        // Перебираем столбцы (элементы строки)
        for (int col = 0; col < row.length; col++) {
            // Сравниваем элемент строки с искомым значением
            if (row[col] == target) {
                System.out.printf("Элемент %d находится в ячейке [%d, %d]\n", target, rowIndex, col);
                found = true;
                break; // При обнаружении элемента завершаем поиск в строке
            }
        }
        if (!found) {
            System.out.printf("В строке %d нет элемента, равного %d\n", rowIndex, target);
        }
    }
}
