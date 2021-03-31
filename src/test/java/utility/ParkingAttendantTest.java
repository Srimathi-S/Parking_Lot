package utility;

import org.junit.jupiter.api.*;

import static org.mockito.Mockito.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ParkingAttendantTest {
    static ParkingLot parkingLot;
    static Car car;
    static ParkingAttendant parkingAttendant;
    static ParkingLot parkingLotSpy;

    @BeforeAll
    static void initializations() {
        parkingLot = new ParkingLot(2);
        parkingLotSpy = spy(parkingLot);
        parkingAttendant = new ParkingAttendant(parkingLotSpy);
        car = mock(Car.class);
    }

    @Test
    void testIfParkingAttendantInvokesParkMethodOfParkingLot() throws NoCapacityException, AlreadyParkedException {
        parkingAttendant.park(car);

        verify(parkingLotSpy).park(car);
    }
}
