package dev.lpa.NestedClasses;

import java.util.ArrayList;
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
        for (var storeEmp : storeEmployees) {
            System.out.println(storeEmp);
        }
    }
}
