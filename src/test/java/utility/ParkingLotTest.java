package utility;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    static ParkingLot parkingLot;

    @BeforeAll
    static void initializations() {
        parkingLot = new ParkingLot(4);
    }

    @Test
    void testIsTrueIfDriverCanParkACar() throws NoCapacityException {
        Car car = new Car("TN12GH3698");

        assertTrue(parkingLot.park(car));
    }

    @Test
    void testIsFalseIfCarIsAlreadyParked() throws NoCapacityException {
        Car car1 = new Car("TN12GH3678");
        Car car2 = new Car("TN12GH3678");
        parkingLot.park(car1);

        assertFalse(parkingLot.park(car2));
    }

    @Test
    void testThrowsExceptionIfParkingLotIsFull() throws NoCapacityException {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car1 = new Car("TS12JS5726");
        Car car2 = new Car("TS62FH2725");
        parkingLot.park(car1);

        assertThrows(NoCapacityException.class, () -> parkingLot.park(car2));

    }
}
