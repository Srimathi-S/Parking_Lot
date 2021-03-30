package utility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ParkingLot {
    private final int capacity;
    private boolean isFull;
    HashSet<Car> parkedCars = new HashSet<>();
    List<Worker> workerList = new ArrayList<>();
    ParkingAttendant parkingAttendant;

    public ParkingLot(int capacity, ParkingAttendant parkingAttendant) {
        this.capacity = capacity;
        this.parkingAttendant = parkingAttendant;
    }

    public void addWorker(Worker worker) {
        workerList.add(worker);
    }

    private boolean checkIfParkingLotIsFull() {
        return capacity - parkedCars.size() == 0;
    }

    public void park(Car car) throws NoCapacityException, AlreadyParkedException {
        if (checkIfParkingLotIsFull())
            throw new NoCapacityException();
        if (parkedCars.contains(car))
            throw new AlreadyParkedException();
        parkingAttendant.park(this, car);
        if (checkIfParkingLotIsFull())
            setIsFull(true);

    }

    private void setIsFull(boolean isFull) {
        this.isFull = isFull;
        workerList.forEach(worker -> worker.notify(isFull));
    }

    public Car unPark(Car car) throws NotParkedException {
        if (parkedCars.contains(car)) {
            if (checkIfParkingLotIsFull())
                setIsFull(false);
            parkedCars.remove(car);
            return car;
        } else
            throw new NotParkedException();
    }
}
