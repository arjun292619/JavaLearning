package dev.lpa.setMethods;

import java.util.*;

public class TreeSetMethods {
    public static void main(String[] args) {
        List<Contact> phones = ContactData.getContactData("phone");
        List<Contact> emails = ContactData.getContactData("email");
        SetMethods.printData("Phone List", phones);

//        NavigableSet<Contact> sorted = new TreeSet<>(phones);
        Comparator<Contact> sortByName = Comparator.comparing(Contact::getName);
        NavigableSet<Contact> sorted = new TreeSet<>(sortByName);
        sorted.addAll(phones);
//        sorted.forEach(System.out::println);
        SetMethods.printData("Navigable Tree Set-Sorted Phone Data", sorted);

        NavigableSet<String> justNames = new TreeSet<>();
        phones.forEach(c -> justNames.add(c.getName()));
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

        Contact min = Collections.min(fullSet, fullSet.comparator());
        Contact max = Collections.max(fullSet, fullSet.comparator());
        Contact first = fullSet.first();
        Contact last = fullSet.last();
        System.out.println(lineSeparator);
        System.out.printf("min = %s, first = %s %n", min, first);
        System.out.printf("max = %s, last = %s %n", max, last);
        System.out.println(lineSeparator);
        NavigableSet<Contact> copiedSet = new TreeSet<>(fullSet);
        System.out.println("pollFirst or removed first element: " + copiedSet.pollFirst());
        System.out.println("pollLast or removed last element: " + copiedSet.pollLast());
        System.out.println(lineSeparator);
        copiedSet.forEach(System.out::println);

        Contact daffy = new Contact("Daffy Duck");
        Contact daisy = new Contact("Daisy Duck");
        Contact snoopy = new Contact("Snoopy");
        Contact archie = new Contact("Archie");

        for (Contact c : List.of(daffy, daisy, snoopy, last, archie)) {
            System.out.printf("ceiling(%s)=%s%n", c.getName(), fullSet.ceiling(c));
            System.out.printf("higher(%s)=%s%n", c.getName(), fullSet.higher(c));
        }
        System.out.println(lineSeparator);

        for (Contact c : List.of(daffy, daisy, snoopy, first, last, archie)) {
            System.out.printf("floor(%s)=%s%n", c.getName(), fullSet.floor(c));
            System.out.printf("lower(%s)=%s%n", c.getName(), fullSet.lower(c));
        }
        System.out.println(lineSeparator);

        SetMethods.printData("FullSet Data Set", fullSet);
        System.out.println(lineSeparator);
        NavigableSet<Contact> descendingSet = fullSet.descendingSet();
        descendingSet.forEach(System.out::println);
        System.out.println(lineSeparator);

        Contact lastContact = descendingSet.pollLast();
        System.out.println("Removed Last from Descending" + lastContact);
        descendingSet.forEach(System.out::println);
        System.out.println(lineSeparator);
        SetMethods.printData("FullSet Print after removing from descindiong",fullSet);
        System.out.println(lineSeparator);

        Contact marion = new Contact("Maid Marion");
        var headSet = fullSet.headSet(marion,true);
        headSet.forEach(System.out::println);
        System.out.println(lineSeparator);

        var tailSet = fullSet.tailSet(marion);
        tailSet.forEach(System.out::println);
        System.out.println(lineSeparator);

        Contact linus = new Contact("Linus Van Pelt");
        var subset = fullSet.subSet(linus,true,marion,true);
//        var subset = fullSet.subSet(marion,true,linus,true);
        subset.forEach(System.out::println);

    }
}
