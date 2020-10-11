package homework_3.aircrafts;

import java.util.Calendar;

public abstract class Aircraft {
    private double flightRange;
    private double liftingCapacity;
    private int yearOfManufacture;

    public abstract void print();

    protected Aircraft(double flightRange, double liftingCapacity, int yearOfManufacture) {
        this.flightRange = flightRange;
        this.liftingCapacity = liftingCapacity;
        this.yearOfManufacture = yearOfManufacture;
    }

    public double getLiftingCapacity() {
        return liftingCapacity;
    }

    public double getFlightRange() {
        return flightRange;
    }

    public int getAge() {
        return Calendar.getInstance().get(Calendar.YEAR) - yearOfManufacture;
    }

}
