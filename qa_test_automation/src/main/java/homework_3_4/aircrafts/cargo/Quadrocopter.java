package homework_3_4.aircrafts.cargo;

public class Quadrocopter extends CargoAircraft {
    private QuadrocopterModel model;

    public Quadrocopter(QuadrocopterModel model, double flightRange, double liftingCapacity, int yearOfManufacture) {
        super(flightRange, liftingCapacity, yearOfManufacture);
        this.model = model;
    }

    @Override
    public void print() {
        System.out.println(String.format("Quadrocopter %s, age: %d years, lifting capacity: %f kg, flight range: %f", model.toString(), getAge(), getLiftingCapacity(), getFlightRange()));
    }
}
