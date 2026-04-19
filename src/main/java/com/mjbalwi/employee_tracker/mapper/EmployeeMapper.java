package com.mjbalwi.employee_tracker.mapper;

import com.mjbalwi.employee_tracker.dto.response.EmployeeResponse;
import com.mjbalwi.employee_tracker.entities.Employee;

public class EmployeeMapper {

    public static EmployeeResponse toResponse(Employee employee) {
        return new EmployeeResponse(
            employee.getId(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getEmail(),
            employee.getPin(),
            employee.getRole()
        );
    }
}

