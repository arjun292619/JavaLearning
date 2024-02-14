package dev.lpa.ListCollections;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

record Place(String name, int distance) {
    @Override
    public String toString() {
        return String.format("%s (%d)", name, distance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Place place = (Place) o;

        return name.equalsIgnoreCase(place.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

public class LinkedListChallenge {
    public static void main(String[] args) {
        LinkedList<Place> placesToVist = new LinkedList<>();
        Place adelaide = new Place("Adelaide", 1374);
        addPlace(placesToVist, adelaide);
        addPlace(placesToVist, new Place("Adelaide", 1274));
        addPlace(placesToVist, new Place("adelaide", 1374));
        addPlace(placesToVist, new Place("Brisbane", 921));
        addPlace(placesToVist, new Place("Perth", 3924));
        addPlace(placesToVist, new Place("Alice Springs", 2771));
        addPlace(placesToVist, new Place("Darwin", 3972));
        addPlace(placesToVist, new Place("Melbourne", 817));

        placesToVist.addFirst(new Place("Sydney", 0));
        System.out.println(placesToVist);

        Scanner scanner = new Scanner(System.in);
        ListIterator<Place> placIterator = placesToVist.listIterator();
        boolean quit = false;
        boolean changeDir = false;
        char direction = 'F';

        printMenu();
        while (!quit) {
            System.out.print("Enter value: ");
            char menuOption = scanner.nextLine().toUpperCase().charAt(0);
            switch (menuOption) {
                case 'F' -> {
                    System.out.println("Moving in Forward Direction");
                    if (direction == 'F' && placIterator.hasNext()) {
                        System.out.println(placIterator.next());
                    } else {
                        direction = 'F';
                        placIterator.next();
                        if (placIterator.hasNext()) {
                            System.out.println(placIterator.next());
                        }
                    }
                }
                case 'B' -> {
                    System.out.println("Moving in Backward Direction");
                    if (direction == 'B' && placIterator.hasPrevious()) {
                        System.out.println(placIterator.previous());
                    } else {
                        direction = 'B';
                        placIterator.previous();
                        if (placIterator.hasPrevious()) {
                            System.out.println(placIterator.previous());
                        }
                    }
                }
                case 'M' -> printMenu();
                case 'L' -> System.out.println(placesToVist);
                default -> quit = true;
            }
        }
    }

    private static void addPlace(LinkedList<Place> list, Place place) {
        if (list.contains(place)) {
            System.out.println("Found Duplicate: " + place);
            return;
        }
        list.add(place);
        list.sort(Comparator.comparing(Place::distance));
    }

    private static void printMenu() {
        System.out.println("""
                Available actions (select word or letter):
                (F)orward
                (B)ackwards
                (L)ist Places
                (M)enu
                (Q)uit
                """);
    }
}
