package ru.job4j.exam.output;

import ru.job4j.exam.Shape;

/**
 * Class ConsoleOutput.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 06.09.2020
 */
public class ConsoleOutput implements Output {
    private final String markX = "X";
    private final String markO = "O";
    private final String markEmpty = " ";

    @Override
    public void start(Shape shape) {
        System.out.println("Начало игры!");
        System.out.println("Строки нумеруются с 0 до " + (shape.cells().length - 1));
        System.out.println("Колонки нумеруются с 0 до " + (shape.cells().length - 1));
        print(shape.cells());
    }

    @Override
    public void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("____________");
            for (int j = 0; j < array[i].length; j++) {
                if (j == 0) {
                    System.out.print("|");
                }
                System.out.print(" " + checkElement(array[i][j]) + " " + "|");
            }
            System.out.println();
            if (i == array.length - 1) {
                System.out.println("____________");
            }
        }
    }

    private String checkElement(int element) {
        String result = markEmpty;
        if (element == 1) {
            result = markX;
        } else if (element == 2) {
            result = markO;
        }
        return result;
    }
}
