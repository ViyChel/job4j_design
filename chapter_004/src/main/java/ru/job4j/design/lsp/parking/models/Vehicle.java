package ru.job4j.design.lsp.parking.models;

import java.util.Objects;

/**
 * Class Vehicle.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 26.08.2020
 */
public abstract class Vehicle {
    private int id;
    private int size;

    /**
     * Instantiates a new Vehicle.
     *
     * @param id   the id
     * @param size the size
     */
    public Vehicle(int id, int size) {
        this.id = id;
        this.size = size;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vehicle vehicle = (Vehicle) o;
        return id == vehicle.id
                && size == vehicle.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, size);
    }
}
