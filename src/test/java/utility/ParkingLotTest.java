package utility;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ParkingLotTest {
    static ParkingLot parkingLot;
    static Car car1, car2, car3;
    static Worker owner, cop;
    static ParkingAttendant parkingAttendant;
    static CareTaker careTaker;

    @BeforeAll
    static void initializations() {
        owner = mock(Worker.class);
        cop = mock(Worker.class);
        car1 = mock(Car.class);
        car2 = mock(Car.class);
        car3 = mock(Car.class);

        parkingLot = new ParkingLot(2);
        parkingAttendant = new ParkingAttendant();
        careTaker = new CareTaker();

        parkingLot.setParkingAttendant(parkingAttendant);
        parkingLot.setCareTaker(careTaker);

        careTaker.addWorker(owner);
        careTaker.addWorker(cop);
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
    void testThrowsExceptionIfDriverParksWhenParkingLotIsFull() {
        assertThrows(NoCapacityException.class, () -> parkingLot.park(car3));
    }

    @Test
    @Order(8)
    void testIfDriverCanUnParkACar() throws NotParkedException {
        Car actualCar = parkingLot.unPark(car1);
        Car expectedCar = car1;

        assertEquals(expectedCar, actualCar);
    }

    @Test
    @Order(6)
    void testThrowsExceptionIfDriverWantsToUnParkANotParkedCar() {
        assertThrows(NotParkedException.class, () -> parkingLot.unPark(car3));
    }

    @Test
    @Order(9)
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

    @Test
    @Order(10)
    void testIfOwnerIsNotifiedWhenCarIsUnParkedAfterParkingLotBeingFull() {
        verify(owner).notifyIsNotFull();
    }

    @Test
    @Order(7)
    void testIfOwnerIsNotNotifiedWhenCarThatIsUnParkedIsNotPresentInParkingLot() {
        verify(owner, times(0)).notifyIsNotFull();
    }

    @Test
    @Order(10)
    void testIfCopIsNotifiedWhenCarIsUnParkedAfterParkingLotBeingFull() {
        verify(cop).notifyIsNotFull();
    }

    @Test
    @Order(7)
    void testIfCopIsNotNotifiedWhenCarThatIsUnParkedIsNotPresentInParkingLot() {
        verify(cop, times(0)).notifyIsNotFull();
    }
}
