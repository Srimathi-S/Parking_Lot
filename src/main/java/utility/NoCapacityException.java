package utility;

public class NoCapacityException extends Exception {
    NoCapacityException() {
        super("Parking Lot is Full");
    }
}
