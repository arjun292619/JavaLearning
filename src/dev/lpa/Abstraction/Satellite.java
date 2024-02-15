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

    public FlightStages getNextStage() {
        FlightStages[] stages = FlightStages.values();
        return stages[(this.ordinal() + 1) % stages.length];
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
