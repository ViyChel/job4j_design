package ru.job4j.exam;

/**
 * Interface Shape.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 09.09.2020
 */
public interface Shape {
    int cellsNumber();

    int[][] cells();

    void add(Player player, int[] param);

    boolean checkFreeCell(int[] arr);
}
