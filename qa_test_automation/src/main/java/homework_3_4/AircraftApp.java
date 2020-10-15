package homework_3_4;

import homework_3_4.aircrafts.Aircraft;
import homework_3_4.aircrafts.cargo.Quadrocopter;
import homework_3_4.aircrafts.cargo.QuadrocopterModel;
import homework_3_4.aircrafts.passenger.Helicopter;
import homework_3_4.aircrafts.passenger.HelicopterModel;
import homework_3_4.aircrafts.passenger.Plane;
import homework_3_4.aircrafts.passenger.PlaneModel;
import homework_3_4.exceptions.airlineExceptions.AirlineException;
import homework_3_4.exceptions.searchExceptions.SearchException;

import java.util.ArrayList;

public class AircraftApp {
    public static void main(String[] args) {
        Airline airline = new Airline("SuperAirline");
        airline.addAircraft(new Plane(PlaneModel.AIRBUS_A320, 5000, 12000, 2006, 150));
        airline.addAircraft(new Plane(PlaneModel.AIRBUS_A320, 6000, 12000, 2017, 180));
        airline.addAircraft(new Plane(PlaneModel.EMBRAER_ERJ190, 5500, 10000, 2012, 110));
        airline.addAircraft(new Plane(PlaneModel.BOEING_747, 6900, 13000, 2011, 190));

        airline.addAircraft(new Helicopter(HelicopterModel.CHINOOK_CH47, 800, 1100, 2011, 40));
        airline.addAircraft(new Helicopter(HelicopterModel.MI8, 1200, 1000, 2014, 20));
        airline.addAircraft(new Helicopter(HelicopterModel.ROBINSON_R44, 1000, 1200, 2010, 4));

        airline.addAircraft(new Quadrocopter(QuadrocopterModel.DJI_MAVIC_AIR, 10, 10, 2018));
        airline.addAircraft(new Quadrocopter(QuadrocopterModel.RYZE_TECH_TELLO, 5, 20, 2019));
        airline.addAircraft(new Quadrocopter(QuadrocopterModel.SYMA_X20, 8, 10, 2017));

        airline.printFleet();
        System.out.println();
        System.out.println("Full passengers capacity: " + airline.getFullPassengersCapacity());
        System.out.println("Full lifting capacity: " + airline.getLiftingCapacity());
        System.out.println();
        airline.sortFleet();
        airline.printFleet();

        System.out.println();
        ArrayList<Aircraft> matchingAircrafts = airline.findAircraft(5, 10500, 5950);
        for (Aircraft aircraft : matchingAircrafts) {
            aircraft.print();
        }

        // Test exceptions:
        // InvalidParameterException:
        try {
            airline.findAircraft(-5, 10500, 5950);
        } catch (SearchException e){
            System.out.println(e);
        }

        // AircraftNotFoundException:
        try {
            airline.findAircraft(5, 10500, 10000000);
        } catch (SearchException e){
            System.out.println(e);
        }

        // NoPassengerAircraftsException:
        try {
            Airline noPassengersAirline = new Airline("NotSoSuperAirline");
            noPassengersAirline.addAircraft(new Quadrocopter(QuadrocopterModel.DJI_MAVIC_AIR, 10, 10, 2018));
            noPassengersAirline.getFullPassengersCapacity();
        } catch (AirlineException e){
            System.out.println(e);
        }

        // EmptyFleetException:
        try {
            Airline emptyFleetAirline = new Airline("NotSuperAtAllAirline");
            emptyFleetAirline.sortFleet();
        } catch (AirlineException e){
            System.out.println(e);
        }
    }
}
