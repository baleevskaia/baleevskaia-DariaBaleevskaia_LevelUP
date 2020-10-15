package homework_3_4.exceptions.airlineExceptions;

import homework_3_4.exceptions.BaseAircraftAppException;

public abstract class AirlineException extends BaseAircraftAppException {
    protected AirlineException(String message){
        super(message);
    }
}
