package dev.lpa.NestedClasses;

import java.util.Comparator;

public class StoreEmployee extends Employee {
    private String storeName;

    public StoreEmployee() {
    }

    public StoreEmployee(int id, String name, int yearStarted, String storeName) {
        super(id, name, yearStarted);
        this.storeName = storeName;
    }

    @Override
    public String toString() {
        return "%-8s %s".formatted(storeName, super.toString());
    }

    public class storeEmpComparator<T extends StoreEmployee> implements Comparator<StoreEmployee> {
        @Override
        public int compare(StoreEmployee o1, StoreEmployee o2) {
            int result = o1.storeName.compareTo(o2.storeName);
            if (result == 0) {
                return new Employee.EmployeeComparator("yearStarted").compare(o1, o2);
            }
            return result;
        }
    }


}
