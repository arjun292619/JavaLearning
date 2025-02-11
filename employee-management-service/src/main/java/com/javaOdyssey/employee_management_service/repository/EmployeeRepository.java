package com.javaOdyssey.employee_management_service.repository;

import com.javaOdyssey.employee_management_service.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
