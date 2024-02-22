package dev.lpa.NestedClasses;

import java.util.Comparator;

public class Employee {
    private String name;
    private int id;
    protected int yearStarted;

    public Employee() {
    }

    public Employee(int id, String name, int yearStarted) {
        this.name = name;
        this.id = id;
        this.yearStarted = yearStarted;
    }

    public static class EmployeeComparator implements Comparator<Employee> {
        String sortType;

        public EmployeeComparator() {
            this("name");
        }

        public EmployeeComparator(String sortType) {
            this.sortType = sortType;
        }

        @Override
        public int compare(Employee o1, Employee o2) {
            return switch (this.sortType.toLowerCase()) {
                case "name" -> o1.name.compareTo(o2.name);
                case "yearstarted" -> Integer.compare(o1.yearStarted, o2.yearStarted);
                default -> Integer.compare(o1.id, o2.id);
            };
//            return Integer.compare(o1.yearStarted, o2.yearStarted);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
//        return "%d %-8s %d".formatted(id, name, yearStarted);
        return String.format("%d %-8s %d", id, name, yearStarted);
    }
}
