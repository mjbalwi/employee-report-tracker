package com.mjbalwi.employee_tracker.repository;

import com.mjbalwi.employee_tracker.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Optional forces you to handle failed/null case

    Optional<Employee> findByEmail(String username);
    Optional<Employee> findByPin(int pin);
}
