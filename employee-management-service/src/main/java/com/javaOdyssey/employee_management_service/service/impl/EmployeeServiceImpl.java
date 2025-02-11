package com.javaOdyssey.employee_management_service.service.impl;

import com.javaOdyssey.employee_management_service.dto.EmployeeDto;
import com.javaOdyssey.employee_management_service.entity.Employee;
import com.javaOdyssey.employee_management_service.exceptions.ResourceNotFoundException;
import com.javaOdyssey.employee_management_service.mapper.EmployeeMapper;
import com.javaOdyssey.employee_management_service.repository.EmployeeRepository;
import com.javaOdyssey.employee_management_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapEmployeeDtoToEmployee(employeeDto);
        Employee saved = employeeRepository.save(employee);
        return EmployeeMapper.mapEmployeeToEmployeeDto(saved);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee with id: " + " not found"));
        return EmployeeMapper.mapEmployeeToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapEmployeeToEmployeeDto).toList();
    }

    @Override
    public EmployeeDto updateEmployeeById(Long id, EmployeeDto employeeDto) {
        Employee fetched = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee with id: " + id + " not found"));
        //update fields if not null or different
        if (employeeDto.getFirstName() != null) fetched.setFirstName(employeeDto.getFirstName());
        if (employeeDto.getLastName() != null) fetched.setLastName(employeeDto.getLastName());
        if (employeeDto.getEmail() != null) fetched.setEmail(employeeDto.getEmail());
        if (employeeDto.getAge() != fetched.getAge()) fetched.setAge(employeeDto.getAge());
        if (employeeDto.getSex() != '\u0000' && employeeDto.getSex() != fetched.getSex()) fetched.setSex(employeeDto.getSex());
        if (employeeDto.getJob() != null) fetched.setJob(employeeDto.getJob());
        if (employeeDto.getDepartment() != null) fetched.setDepartment(employeeDto.getDepartment());
        System.out.println(fetched.toString());
        Employee saved = employeeRepository.save(fetched);
        return EmployeeMapper.mapEmployeeToEmployeeDto(saved);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee with id: " + id + " not found"));
        employeeRepository.deleteById(id);
    }
}
