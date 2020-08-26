package ru.job4j.design.lsp.parking;

import ru.job4j.design.lsp.parking.models.Vehicle;

/**
 * Interface Distribution.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 26.08.2020
 */
public interface Distribution {
    /**
     * Park boolean.
     *
     * @param vehicle the vehicle
     * @return the boolean
     */
    boolean park(Vehicle vehicle);

    /**
     * Unpark boolean.
     *
     * @param vehicle the vehicle
     * @return the boolean
     */
    boolean unpark(Vehicle vehicle);

    /**
     * Gets vehicle by id.
     *
     * @param id the id
     * @return the vehicle by id
     */
    Vehicle getVehicleById(int id);
}
