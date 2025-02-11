package com.javaOdyssey.employee_management_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    private static final double DEFAULT_SALARY = 0.000001;
    private static final String DEFAULT_NA_VAL = "NA";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;
    private int age;

    private char sex;

//    @Column(nullable = false)
    private double salary;

//    @Column(nullable = false)
    private String job;

    private String department;

//    public Employee( String firstName, String lastName) {
//        this();
//        this.getId();
//        this( firstName, lastName, firstName.charAt(0) + lastName + "@email.com", -1, '\u0000', DEFAULT_SALARY, DEFAULT_NA_VAL, DEFAULT_NA_VAL);
//    }
}
