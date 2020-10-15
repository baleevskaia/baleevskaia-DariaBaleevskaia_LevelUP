package homework_3;

import homework_3.aircrafts.Aircraft;
import homework_3.aircrafts.passenger.PassengerAircraft;

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
        return res;
    }

    public double getLiftingCapacity() {
        int res = 0;
        for (Aircraft aircraft : aircrafts) {
            res += aircraft.getLiftingCapacity();
        }
        return res;
    }

    public void sortFleet() {
         Collections.sort(aircrafts, Comparator.comparing(Aircraft::getFlightRange));
    }

    public ArrayList<Aircraft> findAircraft(int age, double liftingCapacity, double flightRange) {
        ArrayList<Aircraft> res = new ArrayList<>();
        for (Aircraft aircraft : aircrafts) {
            if (aircraft.getAge() <= age && aircraft.getLiftingCapacity() >= liftingCapacity && aircraft.getFlightRange() >= flightRange ) {
                res.add(aircraft);
            }
        }
        return res;
    }

    public void printFleet(){
        for (Aircraft aircraft : aircrafts) {
            aircraft.print();
        }
    }
}
