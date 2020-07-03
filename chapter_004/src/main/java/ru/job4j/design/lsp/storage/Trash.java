package ru.job4j.design.lsp.storage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Trash.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 02.07.2020
 */
public class Trash implements Storage {
    private List<Food> list = new ArrayList<>();

    @Override
    public boolean accept(Food food, LocalDate currentDate) {
        return food.getPercentShelfLife(currentDate) > 100;
    }

    @Override
    public void add(Food food) {
        this.list.add(food);
    }

    @Override
    public List<Food> getFoods() {
        return this.list;
    }

    @Override
    public void clear() {
        this.list.clear();
    }
}
