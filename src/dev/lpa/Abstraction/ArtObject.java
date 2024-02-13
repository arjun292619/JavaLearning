package dev.lpa.Abstraction;

public class ArtObject extends GenericProduct {
    public ArtObject(String type, double price, String description) {
        super(type, price, description);
    }

    private static final String lineSeparator = "-".repeat(60);

    @Override
    public void showDetails() {
        System.out.println("This " + type + "(" + getClass().getSimpleName() + ")" + " is a beautiful Art");
        System.out.printf("The price of the piece is %.2f %n", price);
        System.out.println(description);
        System.out.println(lineSeparator);
    }
}
