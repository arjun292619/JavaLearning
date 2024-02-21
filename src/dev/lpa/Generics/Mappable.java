package dev.lpa.Generics;

public interface Mappable {
    void render();

    static double[] stringToLatLong(String location) {
        String[] coord = location.split(",");
        return new double[]{Double.parseDouble(coord[0]), Double.parseDouble(coord[1])};
    }
}
