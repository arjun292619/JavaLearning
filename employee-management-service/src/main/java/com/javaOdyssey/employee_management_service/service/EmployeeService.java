package com.javaOdyssey.employee_management_service.service;

import com.javaOdyssey.employee_management_service.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployeeById(Long id, EmployeeDto employeeDto);

    void deleteById(Long id);
}
