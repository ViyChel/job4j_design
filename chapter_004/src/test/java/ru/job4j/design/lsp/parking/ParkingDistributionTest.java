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
        assertEquals(parking.getPlace(car), 0);
        assertThat(parking.getVehicleById(2), Is.is(truck));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenBothParkingIsBusy() {
        Distribution parking = new ParkingDistribution(1, 2);
        Vehicle truck = new Truck(1, 3);
        parking.park(truck);
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
    public void whenTruckParkingIsBusy() {
        Distribution parking = new ParkingDistribution(5, 2);
        Vehicle truck = new Truck(1, 3);
        assertTrue(parking.park(truck));
        assertThat(parking.getVehicleById(1), Is.is(truck));
    }
}