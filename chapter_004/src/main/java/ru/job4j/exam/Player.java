package ru.job4j.exam;

/**
 * Interface Player.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 06.09.2020
 */
public interface Player {
    int getMark();

    String getName();

    int steps();

    int[] selectCell(Shape shape);
}
