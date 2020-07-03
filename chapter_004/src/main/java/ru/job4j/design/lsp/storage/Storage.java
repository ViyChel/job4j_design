package ru.job4j.design.lsp.storage;

import java.time.LocalDate;
import java.util.List;

/**
 * Interface Storage.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 02.07.2020
 */
public interface Storage {
    /**
     * Accept boolean.
     *
     * @param food        the food
     * @param currentDate the current date
     * @return the boolean
     */
    boolean accept(Food food, LocalDate currentDate);

    /**
     * Add.
     *
     * @param food the food
     */
    void add(Food food);

    /**
     * Gets foods.
     *
     * @return the foods
     */
    List<Food> getFoods();

    /**
     * Clear.
     */
    void clear();
}
