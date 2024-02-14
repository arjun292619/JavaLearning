package dev.lpa.Abstraction;

public class Truck implements Trackable {
    @Override
    public void track() {
        System.out.println(getClass().getSimpleName() + " is being tracked and recorded at location(x,y)");
    }
}
