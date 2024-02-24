package dev.lpa.Generics.challenge;


import java.util.Comparator;
import java.util.Random;

public class StudentType implements QueryItem, Comparable<StudentType> {
    private static int LAST_ID = 10000;

    private int studentId;
    private String name;
    private String course;
    private int yearStarted;

    protected static Random random = new Random();
    private static String[] fnames = {"John", "Bill", "Ronnie", "Tony", "Steve", "Bruce", "Clark", "Martha", "Lois", "Natasha"};
    private static String[] courses = {"C++", "Java", "Python", "Javascript"};

    public StudentType() {
        int lastIndex = random.nextInt(65, 91);
        this.studentId = LAST_ID++;
        this.name = fnames[random.nextInt(0, 10)] + " " + (char) lastIndex;
        this.course = courses[random.nextInt(0, 4)];
        this.yearStarted = random.nextInt(2018, 2025);
    }

    @Override
    public String toString() {
        return "%d %-15s %-15s %d".formatted(studentId, name, course, yearStarted);
    }

    public int getYearStarted() {
        return yearStarted;
    }

    @Override
    public boolean matchFieldValue(String field, String value) {
        String fname = field.toUpperCase();
        return switch (fname) {
            case "NAME" -> value.equalsIgnoreCase(this.name);
            case "COURSE" -> value.equalsIgnoreCase(this.course);
            case "YEARSTARTED" -> yearStarted == Integer.parseInt(value);
            default -> false;
        };
    }

    @Override
    public int compareTo(StudentType o) {
//        return Integer.compare(this.studentId, o.studentId);
        return this.name.compareTo(o.name);
    }
}
