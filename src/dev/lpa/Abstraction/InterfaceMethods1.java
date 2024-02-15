package dev.lpa.Abstraction;

public class InterfaceMethods1 {
    public static void main(String[] args) {
        inFlight(new Jet());
        inFlight(new Satellite());
    }

    private static void inFlight(FlightEnabled flier) {
        flier.takeOff();
        flier.transition(FlightStages.LAUNCH);
        flier.fly();
        if (flier instanceof Trackable trackable) {
            trackable.track();
        }
        if (flier instanceof OrbitEarth orbiter) {
            orbiter.achieveOrbit();
        }
        flier.land();
    }
}
