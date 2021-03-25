package utility;

import java.util.HashSet;

public class ParkingLot {
    private final int capacity;
    private int availableCapacity;
    HashSet<Car> parkedCars = new HashSet<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.availableCapacity = capacity;
    }

    public void park(Car car) throws NoCapacityException, AlreadyParkedException {
        if (availableCapacity == 0)
            throw new NoCapacityException();
        if (parkedCars.contains(car))
            throw new AlreadyParkedException();
        parkedCars.add(car);
        availableCapacity -= 1;
    }
}
