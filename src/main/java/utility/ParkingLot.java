package utility;

import java.util.HashSet;

public class ParkingLot {
    private final int capacity;
    HashSet<Car> parkedCars = new HashSet<>();
    Owner owner;
    TrafficCop cop;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setCop(TrafficCop cop) {
        this.cop = cop;
    }

    private boolean checkIfParkingLotIsFull() {
        return capacity - parkedCars.size() == 0;
    }

    public void park(Car car) throws NoCapacityException, AlreadyParkedException {
        if (checkIfParkingLotIsFull())
            throw new NoCapacityException();
        if (parkedCars.contains(car))
            throw new AlreadyParkedException();
        parkedCars.add(car);
        if (checkIfParkingLotIsFull()) {
            owner.notifyIsFull();
            cop.notifyIsFull();
        }
    }

    public Car unPark(Car car) throws NotParkedException {
        if (parkedCars.contains(car)) {
            if (checkIfParkingLotIsFull()) {
                owner.notifyIsNotFull();
                cop.notifyIsNotFull();
            }
            parkedCars.remove(car);
            return car;
        } else
            throw new NotParkedException();
    }
}
