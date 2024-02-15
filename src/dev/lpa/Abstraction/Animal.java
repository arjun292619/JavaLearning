package dev.lpa.Abstraction;

interface OrbitEarth extends FlightEnabled {
    void achieveOrbit();
}

interface FlightEnabled {

    double MILES_TO_KM = 1.60934;
    double KM_TO_MILES = 0.632137;

    void takeOff();

    void land();

    void fly();

    default FlightStages transition(FlightStages stage) {
        FlightStages nextStage = stage.getNextStage();
        System.out.println("Transitioning from " + stage + " to " + nextStage);
        return nextStage;
    }
}

interface Trackable {
    void track();
}

public abstract class Animal {
    protected String type;
    private String size;
    private double weight;

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public abstract void move(String speed);

    public abstract void makeNoise();

    public final String getExplicitType() {
        return getClass().getSimpleName() + " (" + type + ")";
    }
}
