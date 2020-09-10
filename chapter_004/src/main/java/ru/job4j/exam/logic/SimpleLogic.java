package ru.job4j.exam.logic;

import ru.job4j.exam.Player;
import ru.job4j.exam.Shape;

/**
 * Class LogicThree.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 07.09.2020
 */
public class SimpleLogic implements Winnable {
    private final Logic logic;

    public SimpleLogic(Shape shape) {
        this.logic = new Logic(shape);
    }

    @Override
    public boolean isWinner(Player player) {
        return this.logic.isWin(player.getMark());
    }
}
