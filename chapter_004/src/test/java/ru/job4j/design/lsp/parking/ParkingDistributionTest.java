package ru.job4j.design.lsp.parking;

import org.hamcrest.core.Is;
import org.junit.Test;
import ru.job4j.design.lsp.parking.models.Car;
import ru.job4j.design.lsp.parking.models.Truck;
import ru.job4j.design.lsp.parking.models.Vehicle;

import static org.junit.Assert.*;

/**
 * Class ParkingDistributionTest.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 26.08.2020
 */
public class ParkingDistributionTest {
    @Test
    public void whenBothParkingFree() {
        Distribution parking = new ParkingDistribution(3, 3);
        Vehicle car = new Car(1, 1);
        Vehicle truck = new Truck(2, 2);
        assertTrue(parking.park(car));
        assertTrue(parking.park(truck));
        assertThat(parking.getVehicleById(2), Is.is(truck));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenBothParkingIsBusy() {
        Distribution parking = new ParkingDistribution(1, 1);
        Vehicle car = new Car(1, 1);
        Vehicle truck = new Truck(1, 3);
        Vehicle truck2 = new Truck(1, 3);
        parking.park(car);
        parking.park(truck);
        parking.park(truck2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCarParkingIsBusy() {
        Distribution parking = new ParkingDistribution(1, 3);
        Vehicle car = new Car(1, 1);
        Vehicle car1 = new Car(2, 1);
        parking.park(car);
        parking.park(car1);
    }

    @Test
    public void whenTruckParkingIsBusyAndCarParkingFree() {
        Distribution parking = new ParkingDistribution(5, 2);
        Vehicle truck = new Truck(1, 3);
        assertTrue(parking.park(truck));
        assertThat(parking.getVehicleById(1), Is.is(truck));
    }

    @Test
    public void whenUnparkCar() {
        Distribution parking = new ParkingDistribution(2, 3);
        Vehicle car = new Car(1, 1);
        Vehicle car1 = new Car(2, 1);
        Vehicle car2 = new Car(3, 1);
        parking.park(car);
        parking.park(car1);
        parking.unpark(car);
        assertTrue(parking.park(car2));
        assertThat(parking.getVehicleById(3), Is.is(car2));
    }
}