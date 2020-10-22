package homework_3_4.exceptions.searchExceptions;

public class InvalidParameterException extends SearchException {
    public InvalidParameterException(String message){
        super("Provided search parameter is invalid: " + message);
    }
}
