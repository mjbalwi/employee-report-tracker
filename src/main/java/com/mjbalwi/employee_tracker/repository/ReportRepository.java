package com.mjbalwi.employee_tracker.repository;

import com.mjbalwi.employee_tracker.entities.Report;
import com.mjbalwi.employee_tracker.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    List<Report> findByEmployee(Employee employee);

    List<Report> findReportByEmployeePin(int employeePin);

    Optional<Report> findByEmployeePinAndDate(int pin, LocalDate date);

    Optional<Report> findByDate(LocalDate date);

}
