package ru.job4j.exam;

import ru.job4j.exam.logic.Winnable;

/**
 * Class Computer.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 06.09.2020
 */
public class Computer implements Player {
    private final int mark = 2;
    private final String name;
    private final Winnable logic;
    private int steps;

    public Computer(String name, Winnable logic) {
        this.name = name;
        this.logic = logic;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int steps() {
        return steps;
    }

    @Override
    public int getMark() {
        return mark;
    }

    @Override
    public int[] selectCell(Shape board) {
        System.out.println("Ходит " + this.name);
        int[] result = new int[2];
        do {
            result[0] = (int) (Math.random() * board.cells().length);
            result[1] = (int) (Math.random() * board.cells().length);
        } while (!board.checkFreeCell(result));
        board.add(this, result);
        this.steps++;
        System.out.println("Введите номер строки: " + result[0]);
        System.out.println("Введите номер колонки: " + result[1]);
        return result;
    }
}
