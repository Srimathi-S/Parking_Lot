package utility;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ParkingLotTest {
    static ParkingLot parkingLot;
    static Car car1, car2, car3;

    @BeforeAll
    static void initializations() {
        parkingLot = new ParkingLot(2);
        car1 = new Car();
        car2 = new Car();
        car3 = new Car();
    }

    @Test
    @Order(1)
    void testIfDriverCanParkACar() {
        assertDoesNotThrow(() -> parkingLot.park(car1));
    }

    @Test
    @Order(2)
    void testIsFalseIfCarIsAlreadyParked() {
        assertThrows(AlreadyParkedException.class, () -> parkingLot.park(car1));
    }

    @Test
    @Order(3)
    void testThrowsExceptionIfParkingLotIsFull() throws NoCapacityException, AlreadyParkedException {
        parkingLot.park(car2);

        assertThrows(NoCapacityException.class, () -> parkingLot.park(car3));
    }

    @Test
    @Order(4)
    void testIfDriverCanUnParkACar() throws NotParkedException {
        Car actualCar = parkingLot.unPark(car1);
        Car expectedCar = car1;

        assertEquals(expectedCar, actualCar);
    }

    @Test
    @Order(5)
    void testThrowsExceptionIfDriverWantsToUnParkANotParkedCar() {
        assertThrows(NotParkedException.class, () -> parkingLot.unPark(car3));
    }

    @Test
    @Order(6)
    void testIfDriverCanParkACarAfterUnParking() {
        assertDoesNotThrow(() -> parkingLot.park(car1));
    }
}
