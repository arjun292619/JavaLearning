package com.javaOdyssey.employee_management_service.controller;

import com.javaOdyssey.employee_management_service.dto.EmployeeDto;
import com.javaOdyssey.employee_management_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    //    api endpoint to create a new employee
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto saved = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    //    api endpoint to get an employee
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    //    api endpoint to get an employee
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employeeDtos = employeeService.getAllEmployees();
        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
    }

    //    api endpoint to update employee fields by id
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateById(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto employeeDto) {
        EmployeeDto fetched = employeeService.updateEmployeeById(employeeId, employeeDto);
        return ResponseEntity.ok(fetched);
    }

    //    api endpoint to delete employee by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> updateById(@PathVariable("id") Long employeeId) {
        employeeService.deleteById(employeeId);
        return ResponseEntity.ok("Employee field deleted successfully");
    }
}
