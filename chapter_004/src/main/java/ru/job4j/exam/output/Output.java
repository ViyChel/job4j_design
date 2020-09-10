package ru.job4j.exam.output;

import ru.job4j.exam.Shape;

/**
 * Interface Output.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 06.09.2020
 */
public interface Output {
    void print(int[][] array);

    void start(Shape shape);
}
