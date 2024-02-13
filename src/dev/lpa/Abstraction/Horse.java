package dev.lpa.Abstraction;

public class Horse extends Mammal {
    public Horse(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void makeNoise() {
        System.out.println(getExplicitType() + " neighs");
    }

    @Override
    public void shedHair() {
        System.out.println(getExplicitType() + " sheds hair as it gets old");
    }
}
