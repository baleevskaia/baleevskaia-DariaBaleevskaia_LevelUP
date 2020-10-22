package homework_3_4.exceptions.airlineExceptions;

public class EmptyFleetException extends AirlineException {
    public EmptyFleetException() {
        super("Fleet is empty");
    }
}
