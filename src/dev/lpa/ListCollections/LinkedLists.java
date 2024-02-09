package dev.lpa.ListCollections;

import java.util.LinkedList;
import java.util.List;

public class LinkedLists {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<>();
        placesToVisit.add("Chicago");
        placesToVisit.add("Columbus");
        placesToVisit.add("New York");
        placesToVisit.add("Portland");
        placesToVisit.add(0, "Denver");

        addMoreElements(placesToVisit);
        System.out.println(placesToVisit);
        removeMoreElements(placesToVisit);
        System.out.println(placesToVisit);
        addMoreElements(placesToVisit);
        System.out.println(placesToVisit);
        getElements(placesToVisit);
    }

    private static void addMoreElements(LinkedList<String> list) {
        list.add("San Francisco");
        list.addFirst("Tampa");
        list.addLast("Roswell");
        //queue methods
        list.offer("San Diego");
        list.offerFirst("Miami");
        list.offerLast("Shreveport");
        //stack methods
        list.push("Salt Lake City");
    }

    private static void removeMoreElements(LinkedList<String> list) {
        list.remove(4);
        list.remove("Tampa");
        list.remove();

        String firstRemoved = list.removeFirst();
        System.out.println(firstRemoved + " was removed from the list");

        String lastRemoved = list.removeLast();
        System.out.println(lastRemoved + " was removed from the list");

        //queue methods
        String pollEl = list.poll();
        System.out.println(pollEl + " was removed from the list");
        String pollFirst = list.pollFirst();
        System.out.println(pollFirst + " was removed from the list");
        String pollLast = list.pollLast();
        System.out.println(pollLast + " was removed from the list");

        //stack removal
        String popped = list.pop();
        System.out.println(popped + " was removed from the list");
    }

    private static void getElements(LinkedList<String> list) {
        System.out.println("the fifth element in the list is: " + list.get(4));
        System.out.println("getting the first element in the list is: " + list.getFirst());
        System.out.println("getting the last element in the list is: " + list.getLast());

        System.out.println("SFO is at index "+list.indexOf("San Francisco"));
        System.out.println("SFO is at last index "+list.lastIndexOf("San Francisco"));

        //queue methods
        System.out.println("getting the first element in the list via queue is: " + list.element());

        //stack methods
        System.out.println("getting the first element in the list via stack peek is: " + list.peek());

    }

}
