package dev.lpa.Abstraction;

public class Fish extends Animal {
    public Fish(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        if (speed.equalsIgnoreCase("slow")) {
            System.out.println(getExplicitType() + " is gliding");
        } else {
            System.out.println(getExplicitType() + " is swimming");
        }
    }

    @Override
    public void makeNoise() {
        if (type == "Goldfish") {
            System.out.println("Swish! ");
        } else {
            System.out.println("Swash! ");
        }
    }

}
