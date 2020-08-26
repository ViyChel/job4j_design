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
    boolean park(Vehicle vehicle);

    boolean unpark(Vehicle vehicle);

    int getPlace(Vehicle vehicle);

    Vehicle getVehicleById(int id);
}
