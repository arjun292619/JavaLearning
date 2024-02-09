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

        addMoreElements(placesToVisit);
        System.out.println(placesToVisit);
        removeMoreElements(placesToVisit);
        System.out.println(placesToVisit);
    }

    private static void addMoreElements(LinkedList<String> list){
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

    private static void removeMoreElements(LinkedList<String> list){
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

}
