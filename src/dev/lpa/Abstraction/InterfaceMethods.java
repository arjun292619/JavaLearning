package dev.lpa.Abstraction;

import java.util.ArrayList;
import java.util.List;

public class InterfaceMethods {
    public static void main(String[] args) {
        Bird bird = new Bird("Eagle", "medium", 35);
        Animal animal = bird;
        FlightEnabled flier = bird;
        Trackable tracked = bird;

        inFlight(flier);
        inFlight(new Jet());

        Trackable truck = new Truck();
        truck.track();

        double kmTravelled = 100;
        double milesTravelled = kmTravelled * FlightEnabled.KM_TO_MILES;
        System.out.printf("The truck travlled %.2f km or %.2f miles %n", kmTravelled, milesTravelled);

        System.out.println(bird.KM_TO_MILES);
        System.out.println(bird.MILES_TO_KM);

        OrbitEarth rocket = new Rocket();
        inFlight(rocket);

        List<FlightEnabled> fliers = new ArrayList<>();
        fliers.add(bird);
        fliers.add(rocket);
        triggerFliers(fliers);

//        bird.move("swoops fast");
//        animal.move("swoops fast");
//        flightEnabled.move();
//        trackable.move();

//        flier.takeOff();
//        flier.fly();
//        tracked.track();
//        flier.land();
    }

    private static void inFlight(FlightEnabled flier) {
        flier.takeOff();
        flier.fly();
        if (flier instanceof Trackable trackable) {
            trackable.track();
        }
        if (flier instanceof OrbitEarth orbiter) {
            orbiter.achieveOrbit();
        }
        flier.land();
    }

    private static void triggerFliers(List<FlightEnabled> fliers) {
        for (var flier : fliers) {
//            System.out.println(flier.getClass().getSimpleName() + " is " + (flier instanceof OrbitEarth).);
            System.out.printf("%s is %b instance of Orbit Earth%n", flier.getClass().getSimpleName(), flier instanceof OrbitEarth);
            flier.takeOff();
            flier.fly();
            flier.land();
        }
    }
}
