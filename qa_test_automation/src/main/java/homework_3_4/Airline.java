package homework_3_4;

import homework_3_4.aircrafts.Aircraft;
import homework_3_4.aircrafts.passenger.PassengerAircraft;
import homework_3_4.exceptions.airlineExceptions.EmptyFleetException;
import homework_3_4.exceptions.airlineExceptions.NoPassengerAircraftsException;
import homework_3_4.exceptions.searchExceptions.AircraftNotFoundException;
import homework_3_4.exceptions.searchExceptions.InvalidParameterException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Airline {

    private ArrayList<Aircraft> aircrafts = new ArrayList<>();
    private String name;

    public Airline(String name) {
        this.name = name;
    }

    public void addAircraft(Aircraft aircraft) {
        aircrafts.add(aircraft);
    }

    public int getFullPassengersCapacity() {
        int res = 0;
        for (Aircraft aircraft : aircrafts) {
            if (aircraft instanceof PassengerAircraft) {
                PassengerAircraft passengerAircraft = (PassengerAircraft) aircraft;
                res += passengerAircraft.getPassengerCapacity();
            }
        }
        if (res == 0) {
            throw new NoPassengerAircraftsException();
        }
        return res;
    }

    public double getLiftingCapacity() {
        if (aircrafts.size() == 0) {
            throw new EmptyFleetException();
        }
        int res = 0;
        for (Aircraft aircraft : aircrafts) {
            res += aircraft.getLiftingCapacity();
        }
        return res;
    }

    public void sortFleet() {
        if (aircrafts.size() == 0) {
            throw new EmptyFleetException();
        }
        Collections.sort(aircrafts, Comparator.comparing(Aircraft::getFlightRange));
    }

    public ArrayList<Aircraft> findAircraft(int age, double liftingCapacity, double flightRange) {
        if (age < 0) {
            throw new InvalidParameterException("Age should be positive");
        }
        if (liftingCapacity < 0) {
            throw new InvalidParameterException("Lifting capacity should be positive");
        }
        if (flightRange < 0) {
            throw new InvalidParameterException("Flight range should be positive");
        }
        ArrayList<Aircraft> res = new ArrayList<>();
        for (Aircraft aircraft : aircrafts) {
            if (aircraft.getAge() <= age && aircraft.getLiftingCapacity() >= liftingCapacity && aircraft.getFlightRange() >= flightRange) {
                res.add(aircraft);
            }
        }
        if (res.size() == 0) {
            throw new AircraftNotFoundException();
        }
        return res;
    }

    public void printFleet() {
        if (aircrafts.size() == 0) {
            throw new EmptyFleetException();
        }

        for (Aircraft aircraft : aircrafts) {
            aircraft.print();
        }
    }
}
