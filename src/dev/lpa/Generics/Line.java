package dev.lpa.Generics;

import java.util.Arrays;

public abstract class Line implements Mappable {
    private double[][] locations;

    public Line(String... locations) {
        this.locations = new double[locations.length][];
        int index = 0;
        for (String place : locations) {
            this.locations[index++] = Mappable.stringToLatLong(place);
        }
    }

    public String locations() {
        return Arrays.deepToString(this.locations);
    }

    @Override
    public void render() {
        System.out.println("Render " + this + "as LINE (" + locations() + ")");
    }
}
