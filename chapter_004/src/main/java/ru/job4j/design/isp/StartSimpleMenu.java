package ru.job4j.design.isp;

/**
 * Class StartSimpleMenu.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 02.10.2020
 */
public class StartSimpleMenu {
    public static void main(String[] args) {
        Item item1 = new SimpleItem("Задача 1.");
        Item item11 = new SimpleItem("Задача 1.1.");
        Item item12 = new SimpleItem("Задача 1.2.");
        Item item111 = new SimpleItem("Задача 1.1.1.");
        Item item112 = new SimpleItem("Задача 1.1.2.");

        item1.add(item11);
        item1.add(item12);
        item11.add(item111);
        item11.add(item112);

        Menu menu = new SimpleMenu();
        menu.add(item1);

        menu.add(new SimpleItem("Задача 2."));
        menu.add(new SimpleItem("Задача 3."));
        item111.add(new SimpleItem("Задача 1.1.1.1."));

        menu.show();

        item111.execute();
    }
}
