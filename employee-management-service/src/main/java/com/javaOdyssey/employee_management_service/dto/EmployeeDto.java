package com.javaOdyssey.employee_management_service.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private char sex;
    private double salary;
    private String job;
    private String department;
}
