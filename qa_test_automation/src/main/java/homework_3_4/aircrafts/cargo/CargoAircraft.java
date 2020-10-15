package homework_3_4.aircrafts.cargo;

import homework_3_4.aircrafts.Aircraft;

public abstract class CargoAircraft extends Aircraft {

    protected CargoAircraft(double flightRange, double liftingCapacity, int yearOfManufacture) {
        super(flightRange, liftingCapacity, yearOfManufacture);
    }
}
