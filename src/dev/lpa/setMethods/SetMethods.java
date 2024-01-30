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
        printData("Email Contacts HashSet", emailContacts);
        printData("Phone Contacts HashSet", phoneContacts);

        int index = emails.indexOf(new Contact("Robin Hood"));
        Contact robinhood = emails.get(index);
        System.out.println(robinhood);
        robinhood.addEmail("Sherwood Forest");
        System.out.println(robinhood);

        robinhood.replaceEmail("RHood@sherwoodforest.com", "Hood@sherwoodforest.org");
        System.out.println(robinhood);

        Set<Contact> unionAB = new HashSet<>();
        unionAB.addAll(emailContacts);
        unionAB.addAll(phoneContacts);
        printData("B \u222A A Union of emails(B) and phones(A)", unionAB);

        Set<Contact> intersectEP = new HashSet<>(emailContacts);
        intersectEP.retainAll(phoneContacts);
        printData("E \u2229 P Intersection of emails(E) and phones(P)", intersectEP);

        Set<Contact> intersectPE = new HashSet<>(phoneContacts);
        intersectPE.retainAll(emailContacts);
        printData("P \u2229 E Intersection of phones(P) and emails(E)", intersectPE);

        Set<Contact> EminusP = new HashSet<>(emailContacts);
        EminusP.removeAll(phoneContacts);
        printData("E - P Differences of emails(E) and phones(P)", EminusP);

        Set<Contact> PminusE = new HashSet<>(phoneContacts);
        PminusE.removeAll(emailContacts);
        printData("P -E Differences of phones(P) emails(E)", PminusE);

        Set<Contact> symmetricDiff = new HashSet<>(PminusE);
        symmetricDiff.addAll(EminusP);
        printData("Symmetric Differences of phones(P) emails(E)", symmetricDiff);

        Set<Contact> symmetricDiff2 = new HashSet<>(unionAB);
        symmetricDiff2.removeAll(intersectEP);
        printData("Symmetric Differences2 of phones(P) emails(E)", symmetricDiff2);
    }

    public static void printData(String header, Collection<Contact> contacts) {
        System.out.println("-".repeat(50));
        System.out.println(header);
        System.out.println("-".repeat(50));
        contacts.forEach(System.out::println);
    }
}
