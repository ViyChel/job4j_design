package ru.job4j.design.lsp.parking;

import ru.job4j.design.lsp.parking.models.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    private List<Vehicle> cars;
    private List<Vehicle> trucks;

    /**
     * Instantiates a new Parking distribution.
     *
     * @param carParkingSize   the car parking size
     * @param truckParkingSize the truck parking size
     */
    public ParkingDistribution(int carParkingSize, int truckParkingSize) {
        this.carParkingSize = carParkingSize;
        this.truckParkingSize = truckParkingSize;
        this.cars = new ArrayList<>();
        this.trucks = new ArrayList<>();
    }

    @Override
    public boolean park(Vehicle vehicle) {
        boolean result;
        if (vehicle.getSize() == 1) {
            if (carParkingSize > 0) {
                cars.add(vehicle);
                result = true;
                carParkingSize--;
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            if (truckParkingSize > 0) {
                trucks.add(vehicle);
                result = true;
                truckParkingSize--;
            } else if (truckParkingSize == 0 && carParkingSize >= vehicle.getSize()) {
                cars.add(vehicle);
                result = true;
                carParkingSize -= vehicle.getSize();
            } else {
                throw new IllegalArgumentException();
            }
        }
        return result;
    }

    @Override
    public boolean unpark(Vehicle vehicle) {
        boolean result = false;
        if (this.cars.contains(vehicle)) {
            result = this.cars.remove(vehicle);
            carParkingSize += vehicle.getSize();
        } else if (this.trucks.contains(vehicle)) {
            result = this.trucks.remove(vehicle);
            truckParkingSize++;
        }
        return result;
    }

    @Override
    public Vehicle getVehicleById(int id) {
        List<Vehicle> vehicles = Stream.concat(cars.stream(), trucks.stream()).collect(Collectors.toList());
        return vehicles.stream().filter(el -> el.getId() == id).findFirst().orElseThrow();
    }
}
