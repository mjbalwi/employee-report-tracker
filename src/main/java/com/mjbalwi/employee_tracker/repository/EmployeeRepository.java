package com.mjbalwi.employee_tracker.repository;



import com.mjbalwi.employee_tracker.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
