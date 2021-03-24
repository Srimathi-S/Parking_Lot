package utility;

import java.util.HashSet;

public class ParkingLot {
    private final int capacity ;
    private int availableCapacity;
    HashSet<Car> parkedCars = new HashSet<Car>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.availableCapacity = capacity;
    }

    public boolean park(Car car) {
        if(parkedCars.contains(car))
            return false;
        parkedCars.add(car);
        return true;
    }
}
