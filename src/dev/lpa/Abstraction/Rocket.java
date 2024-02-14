package dev.lpa.Abstraction;

public class Rocket implements OrbitEarth, Trackable {
    @Override
    public void track() {

    }

    @Override
    public void achieveOrbit() {
        System.out.println("Orbit Achieved");
    }

    public void takeOff() {
        System.out.println(getClass().getSimpleName() + " is taking off");
    }

    @Override
    public void land() {
        System.out.println(getClass().getSimpleName() + " is landing");
    }

    @Override
    public void fly() {
        System.out.println(getClass().getSimpleName() + " is flying");
    }
}
