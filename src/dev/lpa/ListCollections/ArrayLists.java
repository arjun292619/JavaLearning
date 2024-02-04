package dev.lpa.ListCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayLists {
    private record GroceryItem(String name, String type, int count) {
        private GroceryItem(String name) {
            this(name, "DAIRY", 1);
        }

        @Override
        public String toString() {
            return "%d %s in %s".formatted(count, name.toUpperCase(), type);
        }
    }

    public static void main(String[] args) {
//        Object[] groceryArray = new Object[3];
        GroceryItem[] groceryArray = new GroceryItem[3];
        groceryArray[0] = new GroceryItem("Milk");
        groceryArray[1] = new GroceryItem("Apples", "PRODUCE", 6);
//        groceryArray[2]= "5 Oranges";
        groceryArray[2] = new GroceryItem("Oranges", "PRODUCE", 5);
        System.out.println(Arrays.toString(groceryArray));

        List objectList = new ArrayList<>();
        objectList.add(new GroceryItem("Butter"));
        objectList.add(new GroceryItem("Yogurt"));
        objectList.add("Chicken");
        System.out.println(objectList);

        List<GroceryItem> groceryList = new ArrayList<>();
        groceryList.add(new GroceryItem("Butter"));
        groceryList.add(new GroceryItem("Yogurt"));
//        groceryList.add("Chicken");
        groceryList.add(new GroceryItem("Chicken", "MEAT", 2));
        groceryList.add(1, new GroceryItem("Hersheys", "Chocolate", 3));
        groceryList.set(1, new GroceryItem("Fish", "Meat", 2));
        groceryList.remove(2);
        groceryList.remove(new GroceryItem("Fish", "Meat", 2));
        System.out.println(groceryList);

        //using List.of for instantiation
        String[] items = {"apples", "bananas", "milk", "eggs"};
        String[] stationaryArray = {"books","pencil","paints","brush","papers"};

        List<String> list = List.of(items);
        System.out.println(list);
        System.out.println(list.getClass().getName());
//        list.add("yogurt");

//        List<String> groceries = new ArrayList<>(list);
        ArrayList<String> groceries = new ArrayList<>(List.of(items));
        groceries.add("yogurt");
        System.out.println(groceries.getClass().getName());
        groceries.addAll(List.of(stationaryArray));
        System.out.println(groceries);
    }
}
