package com.csms.computer_store.Service;




import com.csms.computer_store.Entity.Employee;
import com.csms.computer_store.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // ---------------- General Employee Methods ----------------

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // ---------------- Filter by Role ----------------
    public Optional<Employee> getEmployeesByRole(String role) {
        return employeeRepository.findByRole(role);
    }

    // Optional: Find by email or username
    public Optional<Employee> getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    public Optional<Employee> getEmployeeByUserName(String userName) {
        return employeeRepository.findByUserName(userName);
    }
}
