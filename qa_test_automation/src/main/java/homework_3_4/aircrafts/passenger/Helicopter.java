package homework_3_4.aircrafts.passenger;

public class Helicopter extends PassengerAircraft {
    private HelicopterModel model;

    public Helicopter(HelicopterModel model, double flightRange, double liftingCapacity, int yearOfManufacture, int passengerCapacity) {
        super(flightRange, liftingCapacity, yearOfManufacture, passengerCapacity);
        this.model = model;
    }

    @Override
    public void print() {
        System.out.println(String.format("Helicopter %s, age: %d years, lifting capacity: %f kg, passenger capacity: %d, flight range: %f", model.toString(), getAge(), getLiftingCapacity(), getPassengerCapacity(), getFlightRange()));
    }
}
