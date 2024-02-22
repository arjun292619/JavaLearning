package dev.lpa.Generics;

import java.util.Random;

public class StudentType {
    private String name;
    private String course;
    private int yearStarted;

    protected static Random random = new Random();
    private static String[] fnames = {"John", "Bill", "Ronnie", "Tony", "Steve", "Bruce", "Clark", "Martha", "Lois", "Natasha"};
    private static String[] courses = {"C++", "Java", "Python", "Javascript"};

    public StudentType() {
        int lastIndex = random.nextInt(65, 91);
        this.name = fnames[random.nextInt(0, 10)] + " " + (char) lastIndex;
        this.course = courses[random.nextInt(0, 4)];
        this.yearStarted = random.nextInt(2018, 2025);
    }

    @Override
    public String toString() {
        return "%-15s %-15s %d".formatted(name, course, yearStarted);
    }

    public int getYearStarted() {
        return yearStarted;
    }
}
