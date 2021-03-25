package utility;

public class AlreadyParkedException extends Exception{
    AlreadyParkedException(){
        super("Vehicle is Already Parked!");
    }
}
