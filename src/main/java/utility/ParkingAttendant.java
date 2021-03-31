package utility;

public class ParkingAttendant {
    private ParkingLot parkingLot;

    public ParkingAttendant(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void park(Car car) throws NoCapacityException, AlreadyParkedException {
        parkingLot.park(car);
    }
}
