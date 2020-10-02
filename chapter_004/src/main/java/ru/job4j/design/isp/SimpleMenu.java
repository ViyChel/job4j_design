package ru.job4j.design.isp;

import java.util.ArrayList;
import java.util.List;

/**
 * Class SimpleMenu.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 02.10.2020
 */
public class SimpleMenu implements Menu {
    private List<Item> items = new ArrayList<>();

    @Override
    public void add(Item item) {
        items.add(item);
    }

    @Override
    public void show() {
        for (Item item : items) {
            item.show();
        }
    }
}
