package homework_3_4.aircrafts.passenger;

public class Plane extends PassengerAircraft {
    private PlaneModel model;

    public Plane(PlaneModel model, double flightRange, double liftingCapacity, int yearOfManufacture, int passengerCapacity) {
        super(flightRange, liftingCapacity, yearOfManufacture, passengerCapacity);
        this.model = model;
    }

    @Override
    public void print() {
        System.out.println(String.format("Plane %s, age: %d years, lifting capacity: %f kg, passenger capacity: %d, flight range: %f", model.toString(), getAge(), getLiftingCapacity(), getPassengerCapacity(), getFlightRange()));
    }
}
