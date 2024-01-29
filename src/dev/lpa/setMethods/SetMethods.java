package dev.lpa.setMethods;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetMethods {
    public static void main(String[] args) {
        List<Contact> emails = ContactData.getContactData("emails");
        List<Contact> phones = ContactData.getContactData("phone");
        printData("Phone List", phones);
        printData("Email List", emails);

        Set<Contact> phoneContacts = new HashSet<>(phones);
        Set<Contact> emailContacts = new HashSet<>(emails);
        printData("Email Contacts HashSet",emailContacts);
        printData("Phone Contacts HashSet",phoneContacts);

        int index = emails.indexOf(new Contact("Robin Hood"));
        Contact robinhood = emails.get(index);
        System.out.println(robinhood);
        robinhood.addEmail("Sherwood Forest");
        System.out.println(robinhood);

        robinhood.replaceEmail("RHood@sherwoodforest.com","Hood@sherwoodforest.org");
        System.out.println(robinhood);
    }

    public static void printData(String header, Collection<Contact> contacts){
        System.out.println("-".repeat(50));
        System.out.println(header);
        System.out.println("-".repeat(50));
        contacts.forEach(System.out::println);
    }
}
