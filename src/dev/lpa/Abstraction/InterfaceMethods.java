package dev.lpa.Abstraction;

public class InterfaceMethods {
    public static void main(String[] args) {
        Bird bird = new Bird("Eagle", "medium", 35);
        Animal animal = bird;
        FlightEnabled flier = bird;
        Trackable tracked = bird;

//        bird.move("swoops fast");
//        animal.move("swoops fast");
//        flightEnabled.move();
//        trackable.move();

        flier.takeOff();
        flier.fly();
        tracked.track();
        flier.land();
    }
}
