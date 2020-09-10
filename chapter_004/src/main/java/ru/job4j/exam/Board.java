package ru.job4j.exam;

/**
 * Class Board.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 05.09.2020
 */
public class Board implements Shape {
    private int[][] cells;
    private int cellsNumber;

    public Board(int size) {
        this.cells = new int[size][size];
        this.cellsNumber = size * size;
    }

    @Override
    public int cellsNumber() {
        return cellsNumber;
    }

    @Override
    public int[][] cells() {
        return cells;
    }

    @Override
    public void add(Player player, int[] param) {
        cells[param[0]][param[1]] = player.getMark();
        cellsNumber--;
    }

    @Override
    public boolean checkFreeCell(int[] arr) {
        return cells[arr[0]][arr[1]] == 0;
    }
}
