package dev.lpa.Abstraction;

enum FlightStages implements Trackable {
    GROUNDED, LAUNCH, CRUISE, DATA_COLLECTION;

    @Override
    public void track() {
        System.out.println(getClass().getSimpleName() + "-" + this + " is gettign tracked");
        if (this != GROUNDED) {
            System.out.println("Monitoring " + this);
        }
    }
}

record DragonFly(String name, String type) implements FlightEnabled {
    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}

public class Satellite implements OrbitEarth {
    @Override
    public void achieveOrbit() {
        System.out.println(getClass().getSimpleName() + " achieved Orbit");
    }

    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}
