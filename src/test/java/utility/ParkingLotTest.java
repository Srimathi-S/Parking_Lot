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
    void testIfDriverCanParkACar(){
        Car car = new Car();

        assertDoesNotThrow( ()->parkingLot.park(car));
    }

    @Test
    void testIsFalseIfCarIsAlreadyParked() throws NoCapacityException, AlreadyParkedException {
        Car car = new Car();
        parkingLot.park(car);

        assertThrows(AlreadyParkedException.class,()->parkingLot.park(car));
    }

    @Test
    void testThrowsExceptionIfParkingLotIsFull() throws NoCapacityException, AlreadyParkedException {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car1 = new Car();
        Car car2 = new Car();
        parkingLot.park(car1);

        assertThrows(NoCapacityException.class, () -> parkingLot.park(car2));

    }

}
