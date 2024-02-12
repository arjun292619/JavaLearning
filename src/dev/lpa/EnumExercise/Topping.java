package dev.lpa.EnumExercise;

public enum Topping {
    MUSTARD, PICKLES, BACON, CHEDDAR, TOMATO;

    //    private double price;
    public double getPrice() {
        return switch (this) {
            case BACON -> 1.50;
            case CHEDDAR -> 1.0;
            default -> 0.0;
        };
    }
}
