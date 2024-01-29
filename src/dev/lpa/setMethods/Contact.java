package dev.lpa.setMethods;

import java.util.HashSet;
import java.util.Set;

public class Contact {
    private String name;
    private Set<String> phones = new HashSet<>();
    private Set<String> emails = new HashSet<>();

    public Contact(String name) {
        this(name, null);
    }

    public Contact(String name, String email) {
        this(name, email, 0);
    }

    public Contact(String name, long phone) {
        this(name, null, phone);
    }

    public Contact(String name, String email, long phone) {
        this.name = name;
        if (email != null) {
            emails.add(email);
        }
        if (phone > 0) {
            String tempPhone = String.valueOf(phone);
            tempPhone = "(%s) %s-%s".formatted(tempPhone.substring(0, 3), tempPhone.substring(3, 6), tempPhone.substring(6));
            phones.add(tempPhone);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "%s: %s %s".formatted(name, emails, phones);
    }

    public Contact mergeContact(Contact contact){
        Contact newContact = new Contact(name);
        newContact.emails = new HashSet<>(emails);
        newContact.phones = new HashSet<>(phones);
        newContact.emails.addAll(contact.emails);
        newContact.phones.addAll(contact.phones);
        return newContact;
    }
}
