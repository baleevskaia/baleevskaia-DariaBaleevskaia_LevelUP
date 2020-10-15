package homework_3.aircrafts.cargo;

import homework_3.aircrafts.Aircraft;

public abstract class CargoAircraft extends Aircraft {

    protected CargoAircraft(double flightRange, double liftingCapacity, int yearOfManufacture) {
        super(flightRange, liftingCapacity, yearOfManufacture);
    }
}
