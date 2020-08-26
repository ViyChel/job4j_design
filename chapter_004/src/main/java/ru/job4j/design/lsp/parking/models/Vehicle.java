package ru.job4j.design.lsp.parking.models;

/**
 * Class Car.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 26.08.2020
 */
public abstract class Vehicle {
    private int id;
    private int size;

    public Vehicle(int id, int size) {
        this.id = id;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public int getSize() {
        return size;
    }
}
