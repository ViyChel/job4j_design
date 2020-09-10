package ru.job4j.exam.logic;

import ru.job4j.exam.Player;

/**
 * Interface Winnable.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 07.09.2020
 */
public interface Winnable {
    boolean isWinner(Player player);
}
