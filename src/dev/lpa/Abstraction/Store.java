package dev.lpa.Abstraction;

import java.util.ArrayList;
import java.util.List;

record OrderItem(int quantity, GenericProduct product) {
}

public class Store {
    private static final List<GenericProduct> storeProducts = new ArrayList<>();

    public static void main(String[] args) {
        storeProducts.add(new ArtObject("Oil Painting", 1350, "Abstract Colorful Art work"));
        storeProducts.add(new ArtObject("Sculputure", 2550, "Stone work"));
        storeProducts.add(new Furniture("Desk", 2500, "Mohogany Desk"));
        storeProducts.add(new Furniture("Statue", 4500, "Bronze Leaning Lady"));
        listProducts();
        System.out.println("\n Order1");
        List<OrderItem> order1 = new ArrayList<>();
        addItemToOrder(order1, 1, 2);
        addItemToOrder(order1, 0, 1);
        printOrder(order1);
        System.out.println("\n Order2");
        List<OrderItem> order2 = new ArrayList<>();
        addItemToOrder(order2, 1, 2);
        addItemToOrder(order2, 0, 1);
        addItemToOrder(order2, 3, 2);
        addItemToOrder(order2, 2, 1);
        printOrder(order2);
    }

    public static void listProducts() {
        for (GenericProduct product : storeProducts) {
            System.out.println("-".repeat(100));
            product.showDetails();
        }
    }

    public static void addItemToOrder(List<OrderItem> order, int orderIndex, int quantity) {
        order.add(new OrderItem(quantity, storeProducts.get(orderIndex)));
    }

    public static void printOrder(List<OrderItem> order) {
        double salesTotal = 0;
        for (OrderItem orderItem : order) {
            orderItem.product().printPricedItem(orderItem.quantity());
            salesTotal += orderItem.product().getSalesPrice(orderItem.quantity());
        }
        System.out.printf("Total Sales of Order: $%6.2f%n", salesTotal);
    }
}
