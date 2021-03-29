package utility;

import java.util.HashSet;

public class ParkingLot {
    private final int capacity;
    HashSet<Car> parkedCars = new HashSet<>();
    Owner owner;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    private boolean checkIfParkingLotIsFull(){
        return capacity - parkedCars.size() == 0;
    }

    public void park(Car car) throws NoCapacityException, AlreadyParkedException {
        if (checkIfParkingLotIsFull())
            throw new NoCapacityException();
        if (parkedCars.contains(car))
            throw new AlreadyParkedException();
        parkedCars.add(car);
        if (checkIfParkingLotIsFull())
            owner.notifyIsFull();
    }

    public Car unPark(Car car) throws NotParkedException {
        if (parkedCars.remove(car))
            return car;
        else
            throw new NotParkedException();
    }
}
