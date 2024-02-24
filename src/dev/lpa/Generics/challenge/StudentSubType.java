package dev.lpa.Generics.challenge;

import java.util.Comparator;

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
        return "%s %8.2f%%".formatted(super.toString(), getPercentCompleted());
    }

    @Override
    public boolean matchFieldValue(String field, String value) {
        if (field.equalsIgnoreCase("percentCompleted")) {
            return Double.parseDouble(value) <= percentCompleted;
        }
        return super.matchFieldValue(field, value);
    }

    public static class PercentComparator implements Comparator<StudentSubType> {
        @Override
        public int compare(StudentSubType o1, StudentSubType o2) {
            return Double.compare(o1.percentCompleted, o2.percentCompleted);
        }
    }
}
