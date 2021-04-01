package utility;

import java.util.HashSet;

public class ParkingLot {
    private final int capacity;
    private ParkingAttendant parkingAttendant;
    HashSet<Car> parkedCars = new HashSet<>();
    CareTaker careTaker;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public void setParkingAttendant(ParkingAttendant parkingAttendant) {
        this.parkingAttendant = parkingAttendant;
    }

    public void setCareTaker(CareTaker careTaker) {
        this.careTaker = careTaker;
    }

    private boolean isFull() {
        return capacity - parkedCars.size() == 0;
    }

    public void park(Car car) throws NoCapacityException, AlreadyParkedException {
        if (isFull())
            throw new NoCapacityException();
        if (parkedCars.contains(car))
            throw new AlreadyParkedException();
        parkingAttendant.park(parkedCars, car);
        if (isFull())
            careTaker.notifyIsFull();
    }

    public Car unPark(Car car) throws NotParkedException {
        if (parkedCars.contains(car)) {
            if (isFull())
                careTaker.notifyIsNotFull();
            return parkingAttendant.unPark(parkedCars, car);
        } else
            throw new NotParkedException();
    }
}