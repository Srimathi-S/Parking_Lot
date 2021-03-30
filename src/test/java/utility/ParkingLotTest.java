package utility;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ParkingLotTest {
    static ParkingLot parkingLot;
    static Car car1, car2, car3;
    static Owner owner;
    static TrafficCop cop;

    @BeforeAll
    static void initializations() {
        owner = mock(Owner.class);
        cop = mock(TrafficCop.class);
        parkingLot = new ParkingLot(2);
        parkingLot.setOwner(owner);
        parkingLot.setCop(cop);
        car1 = mock(Car.class);
        car2 = mock(Car.class);
        car3 = mock(Car.class);
    }

    @Test
    @Order(1)
    void testIfDriverCanParkACar() {
        assertDoesNotThrow(() -> parkingLot.park(car1));
    }

    @Test
    @Order(2)
    void testThrowsExceptionIfCarIsAlreadyParked() {
        assertThrows(AlreadyParkedException.class, () -> parkingLot.park(car1));
    }

    @Test
    @Order(5)
    void testThrowsExceptionIfParkingLotIsFull() {
        assertThrows(NoCapacityException.class, () -> parkingLot.park(car3));
    }

    @Test
    @Order(6)
    void testIfDriverCanUnParkACar() throws NotParkedException {
        Car actualCar = parkingLot.unPark(car1);
        Car expectedCar = car1;

        assertEquals(expectedCar, actualCar);
    }

    @Test
    @Order(7)
    void testThrowsExceptionIfDriverWantsToUnParkANotParkedCar() {
        assertThrows(NotParkedException.class, () -> parkingLot.unPark(car3));
    }

    @Test
    @Order(8)
    void testIfDriverCanParkACarAfterUnParking() {
        assertDoesNotThrow(() -> parkingLot.park(car1));
    }

    @Test
    @Order(3)
    void testIfOwnerIsNotifiedWhenParkingLotIsFull() throws NoCapacityException, AlreadyParkedException {
        parkingLot.park(car2);

        verify(owner).notifyIsFull();
    }

    @Test
    @Order(4)
    void testIfCopIsNotifiedWhenParkingLotIsFull() {
        verify(cop).notifyIsFull();
    }
}
