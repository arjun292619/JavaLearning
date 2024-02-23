package dev.lpa.NestedClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Nested {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(10001, "Ralph", 2015),
                new Employee(10009, "Carol", 2021),
                new Employee(10024, "Uma", 2018),
                new Employee(10024, "Hugh", 2016),
                new Employee(10024, "Jim", 2014),
                new Employee(10024, "Dwight", 2011),
                new Employee(10024, "Michael", 2010)
        ));

        Employee[] employeesArray = new Employee[]{new Employee(10001, "Ralph", 2015),
                new Employee(10009, "Carol", 2021),
                new Employee(10024, "Uma", 2018),
                new Employee(10024, "Hugh", 2016),
                new Employee(10024, "Jim", 2014),
                new Employee(10024, "Dwight", 2011),
                new Employee(10024, "Michael", 2010)};

        EmployeeComparator<Employee> employeeComparator = new EmployeeComparator<>();
        System.out.println(employees);
//        employees.sort(employeeComparator);
        employees.sort(new Employee.EmployeeComparator("name"));
//        employees.sort(new Employee.EmployeeComparator("yearStarted"));
//        System.out.println(employees);
        for (var employee : employees) {
            System.out.println(employee);
        }
//        Arrays.sort(employeesArray,employeeComparator);
//        System.out.println(Arrays.toString(employeesArray));

        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10001, "Ralph", 2015, "Walmart"),
                new StoreEmployee(10009, "Carol", 2021, "Target"),
                new StoreEmployee(10024, "Uma", 2018, "Amazon"),
                new StoreEmployee(10024, "Hugh", 2016, "Costco"),
                new StoreEmployee(10024, "Jim", 2014, "Costco"),
                new StoreEmployee(10024, "Dwight", 2011, "Walmart"),
                new StoreEmployee(10024, "Michael", 2010, "Target")
        ));
        System.out.println("Store Employees");
        System.out.println(storeEmployees);
        storeEmployees.sort(new StoreEmployee().new storeEmpComparator<>());
//        storeEmployees.sort(new Employee.EmployeeComparator());
        for (var storeEmp : storeEmployees) {
            System.out.println(storeEmp);
        }
// anonymous classes
        List<StoreEmployee> houseEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10023, "House", 2015, "Walmart"),
                new StoreEmployee(10008, "Chase", 2021, "Target"),
                new StoreEmployee(10065, "Olivia", 2018, "Amazon"),
                new StoreEmployee(10345, "Allison", 2016, "Costco"),
                new StoreEmployee(10049, "Taub", 2014, "Costco"),
                new StoreEmployee(10165, "James", 2011, "Walmart"),
                new StoreEmployee(10454, "Lisa", 2010, "Target")
        ));
        houseEmployees.sort(new Comparator<StoreEmployee>() {
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                int result = o1.getName().compareTo(o2.getName());
                if (result == 0) {
                    return Integer.compare(o1.yearStarted, o2.yearStarted);
                }
                return result;
            }
        });

        System.out.println(houseEmployees);
        addPigLatinName(houseEmployees);
    }

    public static void addPigLatinName(List<? extends StoreEmployee> list) {
        class PigLatin implements Comparable<PigLatin> {
            private String pigLatinName;
            private Employee employee;

            public PigLatin(String pigLatinName, Employee employee) {
                this.employee = employee;
                this.pigLatinName = pigLatinName;
            }

            @Override
            public String toString() {
                return employee.toString() + " " + pigLatinName;
            }

            @Override
            public int compareTo(PigLatin o) {
                return this.pigLatinName.compareTo(o.pigLatinName);
            }
        }
        List<PigLatin> pigListNames = new ArrayList<>(list.size());
        for (var element : list) {
            String name = element.getName();
            String pigLatin = name.substring(1) + name.charAt(0) + "ay";
            pigListNames.add(new PigLatin(pigLatin, element));
        }
        pigListNames.sort(null);
        for (var element : pigListNames) {
            System.out.println(element);
        }
    }
}
