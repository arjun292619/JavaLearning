package dev.lpa.ListCollections;

import java.util.LinkedList;

public class LinkedLists {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<>();
        placesToVisit.add("Chicago");
        placesToVisit.add("Columbus");
        placesToVisit.add("New York");
        placesToVisit.add("Portland");
        placesToVisit.add(0,"Denver");
        System.out.println(placesToVisit);
    }
}
