package homework_3_4.exceptions.searchExceptions;

import homework_3_4.exceptions.BaseAircraftAppException;

public abstract class SearchException extends BaseAircraftAppException {
    protected SearchException(String message){
        super(message);
    }
}
