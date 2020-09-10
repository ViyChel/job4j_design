package ru.job4j.exam.logic;

import ru.job4j.exam.Shape;

/**
 * Class Logic.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 06.09.2020
 */
public class Logic {
    private Shape shape;

    public Logic(Shape shape) {
        this.shape = shape;
    }

    private boolean fillBy(int mark, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.shape.cells().length; index++) {
            int cell = this.shape.cells()[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (mark != cell) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWin(int mark) {
        return this.fillBy(mark, 0, 0, 1, 0)
                || this.fillBy(mark, 0, 1, 1, 0)
                || this.fillBy(mark, 0, 2, 1, 0)
                || this.fillBy(mark, 0, 0, 0, 1)
                || this.fillBy(mark, 1, 0, 0, 1)
                || this.fillBy(mark, 2, 0, 0, 1)
                || this.fillBy(mark, 0, 0, 1, 1)
                || this.fillBy(mark, 2, 0, -1, 1);
    }
}