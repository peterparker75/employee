package com.example.employee.repository;

import java.util.List;
import java.util.Optional;
import com.example.employee.model.Employee;

public interface EmployeeRepository {
    List<Employee> findAll();

    Optional<Employee> findById(int employeeId);

    Employee save(Employee employee);

    void deleteById(int employeeId);
}
