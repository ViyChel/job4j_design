package ru.job4j.exam;

import ru.job4j.exam.logic.Winnable;

import java.util.Scanner;

/**
 * Class Human.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 06.09.2020
 */
public class Human implements Player {
    private final int mark = 1;
    private final String name;
    private final Winnable logic;
    private int steps;

    public Human(String name, Winnable logic) {
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
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        do {
            System.out.print("Введите номер строки: ");
            result[0] = scanner.nextInt();
            System.out.print("Введите номер колонки: ");
            result[1] = scanner.nextInt();
            if (board.checkFreeCell(result)) {
                check = true;
                board.add(this, result);
                this.steps++;
            } else {
                System.out.println("Указанная ячейка занята. Попробуйте ещё раз.");
            }
        } while (!check);
        return result;
    }
}
