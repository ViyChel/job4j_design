package ru.job4j.exam.logic;

import ru.job4j.exam.Player;
import ru.job4j.exam.Shape;

/**
 * Class LogicFive.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 07.09.2020
 */
public class FiveLogic implements Winnable {
    private final Logic logic;

    public FiveLogic(Shape shape) {
        this.logic = new Logic(shape);
    }

    @Override
    public boolean isWinner(Player player) {
        boolean result = false;
        if (this.logic.isWin(player.getMark()) && player.steps() == 5) {
            result = true;
        } else if (this.logic.isWin(player.getMark()) && player.steps() > 5) {
            throw new IllegalStateException("Превышено количество ходов. Никто не выиграл!");
        }
        return result;
    }
}
