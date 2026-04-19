package com.mjbalwi.employee_tracker.dto.request;

import com.mjbalwi.employee_tracker.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest {
    private String firstName;
    private String lastName;
    private String email;
    private int pin;
    private Role role;
}
