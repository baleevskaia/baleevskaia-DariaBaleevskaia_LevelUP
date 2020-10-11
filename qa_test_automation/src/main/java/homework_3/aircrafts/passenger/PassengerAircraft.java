package homework_3.aircrafts.passenger;

import homework_3.aircrafts.Aircraft;

public abstract class PassengerAircraft extends Aircraft {
    private int passengerCapacity;

    protected PassengerAircraft(double flightRange, double liftingCapacity, int yearOfManufacture, int passengerCapacity) {
        super(flightRange, liftingCapacity, yearOfManufacture);
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity(){
        return passengerCapacity;
    }
}
