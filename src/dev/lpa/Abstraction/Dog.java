package dev.lpa.Abstraction;

public class Dog extends Mammal {
    public Dog(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        if (speed.equalsIgnoreCase("slow")) {
            System.out.println(getExplicitType() + " is walking");
        } else {
            System.out.println(getExplicitType() + " is running");
        }
    }

    @Override
    public void shedHair() {
        System.out.println(getExplicitType() + " sheds alot of hair");
    }

    @Override
    public void makeNoise() {
        if (type == "Wolf") {
            System.out.println("Howling! ");
        } else {
            System.out.println("Woof! ");
        }
    }

}
