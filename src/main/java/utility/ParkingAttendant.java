package utility;

public class ParkingAttendant {
    public void park(ParkingLot parkingLot, Car car) {
        parkingLot.parkedCars.add(car);
    }
}
