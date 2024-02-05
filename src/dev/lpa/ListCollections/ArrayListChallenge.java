package dev.lpa.ListCollections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ArrayListChallenge {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean flag = true;
        ArrayList<String> groceryList = new ArrayList<>();
        while (flag) {
            printActions();
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1 -> addItems(groceryList);
                case 2 -> removeItems(groceryList);
                default -> flag = false;
            }
            groceryList.sort(Comparator.naturalOrder());
            System.out.println(groceryList);
        }

    }

    private static void printActions() {
        String menuBlock = """
                Available actions:
                                
                0 - to shutdown
                                
                1 - to add item(s) to list (comma delimited list)
                                
                2 - to remove any items (comma delimited list)
                                
                Enter a number for which action you want to do:""";
        System.out.print(menuBlock + " ");
    }

    private static void addItems(ArrayList<String> groceries) {
        System.out.println("Add items separated by commas");
        String[] items = scanner.nextLine().split(",");
//        groceries.addAll(List.of(items));
        for (String item : items) {
            String trimmedItem = item.trim();
            if (!groceries.contains(trimmedItem)) {
                groceries.add(trimmedItem);
            }
        }
    }

    private static void removeItems(ArrayList<String> groceries) {
        System.out.println("Add items separated by commas");
        String[] items = scanner.nextLine().split(",");
//        groceries.addAll(List.of(items));
        for (String item : items) {
            String trimmedItem = item.trim();
            groceries.remove(trimmedItem);
        }
    }
}
