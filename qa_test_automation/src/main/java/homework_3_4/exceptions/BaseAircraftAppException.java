package homework_3_4.exceptions;

public abstract class BaseAircraftAppException extends RuntimeException {
    public BaseAircraftAppException(String message){
        super(message);
    }
}
