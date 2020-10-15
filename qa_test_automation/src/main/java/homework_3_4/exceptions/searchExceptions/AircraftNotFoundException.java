package homework_3_4.exceptions.searchExceptions;

public class AircraftNotFoundException extends SearchException {
    public AircraftNotFoundException(){
        super("No aircrafts found by provided parameters");
    }
}
