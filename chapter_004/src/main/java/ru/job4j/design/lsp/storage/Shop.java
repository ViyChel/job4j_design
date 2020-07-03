package ru.job4j.design.lsp.storage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Shop.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 02.07.2020
 */
public class Shop implements Storage {
    private List<Food> list = new ArrayList<>();

    @Override
    public boolean accept(Food food, LocalDate currentDate) {
        boolean result = false;
        int percentShelfLife = food.getPercentShelfLife(currentDate);
        if (percentShelfLife >= 25 && percentShelfLife < 75) {
            result = true;
        } else if (percentShelfLife >= 75 && percentShelfLife <= 100) {
            food.setPrice(food.getPriceWithDiscount());
            result = true;
        }
        return result;
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
