
package com.example.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeJpaRepository;
import com.example.employee.repository.EmployeeRepository;

import java.util.List;
//employee

@Service
public class EmployeeJpaService {

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    public List<Employee> getAllEmployees() {
        return employeeJpaRepository.findAll();
    }

    public Employee getEmployeeById(int employeeId) {
        return employeeJpaRepository.findById(employeeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
    }

    public Employee createEmployee(Employee employee) {
        return employeeJpaRepository.save(employee);
    }

    public Employee updateEmployee(int employeeId, Employee updatedEmployee) {
        Employee employee = getEmployeeById(employeeId);
        employee.setEmployeeName(updatedEmployee.getEmployeeName());
        employee.setEmail(updatedEmployee.getEmail());
        return employeeJpaRepository.save(employee);
    }

    public void deleteEmployee(int employeeId) {
        getEmployeeById(employeeId); // This ensures that an exception is thrown if not found
        employeeJpaRepository.deleteById(employeeId);
    }
}
