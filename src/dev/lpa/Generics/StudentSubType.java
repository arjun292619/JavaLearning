package dev.lpa.Generics;

public class StudentSubType extends StudentType {
    private double percentCompleted;

    public StudentSubType() {
        this.percentCompleted = random.nextDouble(0, 100.001);
    }

    public double getPercentCompleted() {
        return percentCompleted;
    }

    @Override
    public String toString() {
        return "%s %8.1f".formatted(super.toString(), getPercentCompleted());
    }
}
