package dev.lpa.setMethods;

import java.util.*;

public class TreeSetMethods {
    public static void main(String[] args) {
        List<Contact> phones = ContactData.getContactData("phone");
        List<Contact> emails = ContactData.getContactData("email");
        SetMethods.printData("Phone List",phones);

//        NavigableSet<Contact> sorted = new TreeSet<>(phones);
        Comparator<Contact> sortByName = Comparator.comparing(Contact::getName);
        NavigableSet<Contact> sorted = new TreeSet<>(sortByName);
        sorted.addAll(phones);
//        sorted.forEach(System.out::println);
        SetMethods.printData("Navigable Tree Set-Sorted Phone Data",sorted);

        NavigableSet<String> justNames = new TreeSet<>();
        phones.forEach(c->justNames.add(c.getName()));
        System.out.println(justNames);

        NavigableSet<Contact> fullSet = new TreeSet<>(sorted);
        fullSet.addAll(emails);
        fullSet.forEach(System.out::println);

        String lineSeparator = "-".repeat(90);
        System.out.println(lineSeparator);

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.forEach(System.out::println);
        System.out.println(lineSeparator);
        fullList.sort(sorted.comparator());
        fullList.forEach(System.out::println);

        Contact min = Collections.min(fullSet,fullSet.comparator());
        Contact max = Collections.max(fullSet,fullSet.comparator());
        Contact first = fullSet.first();
        Contact last = fullSet.last();
        System.out.println(lineSeparator);
        System.out.printf("min = %s, first = %s %n", min, first);
        System.out.printf("max = %s, last = %s %n", max, last);
        System.out.println(lineSeparator);
        NavigableSet<Contact> copiedSet = new TreeSet<>(fullSet);
        System.out.println("pollFirst or removed first element: "+ copiedSet.pollFirst());
        System.out.println("pollLast or removed last element: "+ copiedSet.pollLast());
        System.out.println(lineSeparator);
        copiedSet.forEach(System.out::println);
    }
}
