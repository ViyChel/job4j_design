package ru.job4j.design.isp;

import java.util.ArrayList;
import java.util.List;

/**
 * Class SimpleItem.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 02.10.2020
 */
public class SimpleItem implements Item {
    private final String name;
    private List<Item> items = new ArrayList<>();
    private String prefix = "";
    private boolean child;

    public SimpleItem(String name) {
        this.name = name;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setChild(Item item) {
        SimpleItem simpleItem = (SimpleItem) item;
        simpleItem.child = true;
    }

    @Override
    public void execute() {
        System.out.printf("%s - %s", name, "performing some action");
    }

    @Override
    public void add(Item item) {
        setChild(item);
        setPrefix(item);
        items.add(item);
    }

    private void setPrefix(Item item) {
        SimpleItem simpleItem = (SimpleItem) item;
        String prefixSymbol = "----";
        StringBuilder build = new StringBuilder(prefix).insert(0, prefixSymbol);
        String itemPrefix = build.toString();
        simpleItem.setPrefix(itemPrefix);
    }


    @Override
    public void show() {
        if (this.child) {
            System.out.println(prefix + " " + name);
        } else {
            System.out.println(prefix + name);
        }
        if (!items.isEmpty()) {
            for (Item item : items) {
                item.show();
            }
        }
    }
}
