package com.javaOdyssey.employee_management_service.mapper;

import com.javaOdyssey.employee_management_service.dto.EmployeeDto;
import com.javaOdyssey.employee_management_service.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapEmployeeToEmployeeDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName() , employee.getEmail(), employee.getAge(), employee.getSex(), employee.getSalary(), employee.getJob(), employee.getDepartment());
        return employeeDto;
    }

    public static Employee mapEmployeeDtoToEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName() , employeeDto.getEmail(), employeeDto.getAge(), employeeDto.getSex(), employeeDto.getSalary(), employeeDto.getJob(), employeeDto.getDepartment());
        return employee;
    }

}
