package ru.job4j.exam;

import ru.job4j.exam.logic.Winnable;
import ru.job4j.exam.output.Output;

/**
 * Class Game.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 16.09.2020
 */
public class Game {

    public void start(Shape board, Winnable logic, Player player1, Player player2, Output out) {
        out.start(board);
        while (board.cellsNumber() > 0) {
            player1.selectCell(board);
            out.print(board.cells());
            if (logic.isWinner(player1)) {
                System.out.println(player1.getName() + " выиграл!");
                break;
            } else if (board.cellsNumber() == 0) {
                break;
            }
            player2.selectCell(board);
            out.print(board.cells());
            if (logic.isWinner(player2)) {
                System.out.println(player2.getName() + " выиграл!");
                break;
            }
        }
    }
}
