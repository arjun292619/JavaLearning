package dev.lpa.Abstraction;

public class Bird extends Animal implements FlightEnabled, Trackable {
    public Bird(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        System.out.println("Bird Flaps its wings to Fly and " + speed);
    }

    @Override
    public void makeNoise() {
        System.out.println("Bird Coos and Caws");
    }

    @Override
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

    @Override
    public void track() {
        System.out.println(getClass().getSimpleName() + " is being tracked and recorded at location(x,y)");
    }
}
