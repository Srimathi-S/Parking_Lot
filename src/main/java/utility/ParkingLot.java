package utility;

import java.util.HashSet;

public class ParkingLot {
    private int availableCapacity;
    HashSet<Car> parkedCars = new HashSet<>();
    Owner owner;

    public ParkingLot(int capacity, Owner owner) {
        this.availableCapacity = capacity;
        this.owner = owner;
    }

    public void park(Car car) throws NoCapacityException, AlreadyParkedException {
        if (availableCapacity == 0)
            throw new NoCapacityException();
        if (parkedCars.contains(car))
            throw new AlreadyParkedException();
        parkedCars.add(car);
        availableCapacity -= 1;
        if (availableCapacity == 0)
            owner.notifyIsFull();
    }

    public Car unPark(Car car) throws NotParkedException {
        if (parkedCars.remove(car)) {
            availableCapacity += 1;
            return car;
        } else
            throw new NotParkedException();
    }
}
