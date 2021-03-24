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

    public boolean park(Car car) throws NoCapacityException {
        if (availableCapacity == 0)
            throw new NoCapacityException();
        if (parkedCars.contains(car))
            return false;
        parkedCars.add(car);
        availableCapacity -= 1;
        return true;
    }
}
