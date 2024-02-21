package dev.lpa.Generics;

import java.util.Arrays;

public abstract class Point implements Mappable {
    private double[] location = new double[2];

    public Point(String location) {
        this.location = Mappable.stringToLatLong(location);
    }

    @Override
    public void render() {
        System.out.println("Render " + this + " as Point (" + location() + ")");
    }

    private String location() {
        return Arrays.toString(location);
    }
}
