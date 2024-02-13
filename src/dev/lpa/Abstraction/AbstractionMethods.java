package dev.lpa.Abstraction;

import java.util.ArrayList;
import java.util.List;

public class AbstractionMethods {
    public static void main(String[] args) {
        String lineSeparator = "-".repeat(90);
        Dog dog1 = new Dog("Wolf", "big", 120);
        Dog dog2 = new Dog("German Sheperd", "big", 150);
        Dog dog3 = new Dog("Pug", "small", 35);
        dog1.makeNoise();
        System.out.println(lineSeparator);

        doAnimalStuff(dog1);
        System.out.println(lineSeparator);

        Fish fish1 = new Fish("Goldfish", "small", 2);
        Horse horse1 = new Horse("Jackie", "pony", 100);

        List<Animal> animals = new ArrayList<>(List.of(dog2, dog1, dog3, fish1, new Fish("Barracuda", "big", 590), horse1));

        for (Animal animal : animals) {
            doAnimalStuff(animal);
            if(animal instanceof Mammal mammal){
                mammal.shedHair();
            }
        }
    }

    public static void doAnimalStuff(Animal animal) {
        animal.makeNoise();
        animal.move("Slow");
    }
}
