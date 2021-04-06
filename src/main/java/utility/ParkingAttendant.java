package utility;

import java.util.HashSet;

public class ParkingAttendant {
    public void park(HashSet<Car> parkedCars, Car car) {
        parkedCars.add(car);
    }

    public Car unPark(HashSet<Car> parkedCars, Car car) {
        parkedCars.remove(car);
        return car;
    }
}
