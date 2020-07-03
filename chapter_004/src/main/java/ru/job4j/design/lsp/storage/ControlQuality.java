package ru.job4j.design.lsp.storage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Class ControlQuality.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 02.07.2020
 */
public class ControlQuality {
    private List<Storage> storages;

    /**
     * Instantiates a new Control quality.
     *
     * @param storages the storages
     */
    public ControlQuality(List<Storage> storages) {
        this.storages = storages;
    }

    /**
     * Distribute.
     *
     * @param food the food
     * @param date the date
     */
    public void distribute(Food food, LocalDate date) {
        for (Storage storage : this.storages) {
            if (storage.accept(food, date)) {
                storage.add(food);
                break;
            }
        }
    }

    /**
     * Resort.
     *
     * @param date the date
     */
    public void resort(LocalDate date) {
        List<Food> foods = new ArrayList<>();
        for (Storage storage: this.storages) {
            foods.addAll(storage.getFoods());
            storage.clear();
        }
        foods.forEach(food -> distribute(food, date));
    }
}
