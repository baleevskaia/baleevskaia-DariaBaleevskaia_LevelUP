package homework_3_4.exceptions.airlineExceptions;

public class NoPassengerAircraftsException extends AirlineException {
    public NoPassengerAircraftsException() {
        super("No passenger aircrafts in a fleet");
    }
}
