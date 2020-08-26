package ru.job4j.design.lsp.parking;

import ru.job4j.design.lsp.parking.models.Vehicle;

/**
 * Class ParkingDistribution.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 26.08.2020
 */
public class ParkingDistribution implements Distribution {
    private int carParkingSize;
    private int truckParkingSize;
    private Vehicle[] cars;
    private Vehicle[] trucks;

    public ParkingDistribution(int carParkingSize, int truckParkingSize) {
        this.carParkingSize = carParkingSize;
        this.cars = new Vehicle[carParkingSize];
        this.truckParkingSize = truckParkingSize;
        this.trucks = new Vehicle[truckParkingSize];
    }

    @Override
    public boolean park(Vehicle vehicle) {
        return false;
    }

    @Override
    public boolean unpark(Vehicle vehicle) {
        return false;
    }

    @Override
    public int getPlace(Vehicle vehicle) {
        return 0;
    }

    @Override
    public Vehicle getVehicleById(int id) {
        return null;
    }
}
