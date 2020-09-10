package ru.job4j.exam;

import ru.job4j.exam.logic.SimpleLogic;
import ru.job4j.exam.logic.Winnable;
import ru.job4j.exam.output.ConsoleOutput;
import ru.job4j.exam.output.Output;

/**
 * Class TicTacToe.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 06.09.2020
 */
public class TicTacToe {

    public static void main(String[] args) {
        Shape board = new Board(3);
        Game game = new Game();
        Winnable logic = new SimpleLogic(board);
        Player human = new Human("человек", logic);
        Player computer = new Computer("компьютер", logic);
        Output out = new ConsoleOutput();
        game.start(board, logic, computer, human, out);
    }
}
