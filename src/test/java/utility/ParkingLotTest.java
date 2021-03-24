package utility;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingLotTest {
    static ParkingLot parkingLot;

    @BeforeAll
    static void initializations(){
        parkingLot = new ParkingLot(4);
    }

    @Test
    void testIsTrueIfDriverCanParkACar() {
        Car car=new Car("TN12GH3698");

        assertTrue(parkingLot.park(car));
    }

    @Test
    void testIsFalseIfCarIsAlreadyParked() {
        Car car1=new Car("TN12GH3678");
        Car car2=new Car("TN12GH3678");
        parkingLot.park(car1);

        assertFalse(parkingLot.park(car2));
    }
}
