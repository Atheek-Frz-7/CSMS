package com.csms.computer_store.Repository;



import com.csms.computer_store.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Find employee by email
    Optional<Employee> findByEmail(String email);

    // Find employee by phone
    Optional<Employee> findByPhone(String phone);

    // You can add custom queries if needed, e.g., find by role
    Optional<Employee> findByRole(String role);

    Optional<Employee> findByUserName(String userName);
}
