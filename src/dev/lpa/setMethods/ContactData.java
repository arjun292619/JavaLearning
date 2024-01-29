package dev.lpa.setMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactData {
    private static final String phoneData = """
            Maid Marion, 1234567890
                        Mickey Mouse, 9998887777
                        Mickey Mouse, 1247489758
                        Minnie Mouse, 4567805666
                        Robin Hood, 5647893000
                        Robin Hood, 7899028222
                        Lucy Van Pelt, 5642086852
                        Mickey Mouse, 9998887777
            """;

    private static final String emailData = """
            Mickey Mouse, mckmouse@gmail.com
                        Mickey Mouse, micky1@aws.com
                        Minnie Mouse, minnie@verizon.net
                        Robin Hood, rhood@gmail.com
                        Linus Van Pelt, lvpelt2015@gmail.com
                        Daffy Duck, daffy@google.com
            """;

    public static List<Contact> getContactData(String type) {
        List<Contact> contactList = new ArrayList<>();
        Scanner scanner = new Scanner(type.toLowerCase().equals("phone") ? phoneData : emailData);
        while (scanner.hasNext()) {
            String[] lineData = scanner.nextLine().split(",");
            Arrays.asList(lineData).replaceAll(String::trim);
            if (type.equals("phone")) {
                contactList.add(new Contact(lineData[0], Long.parseLong(lineData[1])));
            } else {
                contactList.add(new Contact(lineData[0], lineData[1]));
            }
        }
        return contactList;
    }
}
