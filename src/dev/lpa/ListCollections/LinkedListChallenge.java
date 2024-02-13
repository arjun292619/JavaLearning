package dev.lpa.ListCollections;

import java.util.Comparator;
import java.util.LinkedList;

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
    }

    private static void addPlace(LinkedList<Place> list, Place place) {
        if (list.contains(place)) {
            System.out.println("Found Duplicate: " + place);
            return;
        }
        list.add(place);
        list.sort(Comparator.comparing(Place::distance));
    }
}
