package com.mjbalwi.employee_tracker.dto.response;

import com.mjbalwi.employee_tracker.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int pin;
    private Role role;
}