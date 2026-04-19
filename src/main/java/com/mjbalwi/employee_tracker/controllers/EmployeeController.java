/**
 *
 */

package com.mjbalwi.employee_tracker.controllers;

import com.mjbalwi.employee_tracker.dto.request.CreateEmployeeRequest;
import com.mjbalwi.employee_tracker.dto.response.EmployeeResponse;
import com.mjbalwi.employee_tracker.entities.Employee;
import com.mjbalwi.employee_tracker.mapper.EmployeeMapper;
import com.mjbalwi.employee_tracker.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    /**
     * Creates a new employee.
     * Springboot automatically converts incoming JSON request body into a
     * CreateEmployeeObject.
     *
     * Used DTOs to prevent serialization loop between employee and Report
     *
     * @param request contains the employee details from incoming request body
     * @return the newly created employee
     */
    @PostMapping
    public EmployeeResponse createEmployee(@RequestBody CreateEmployeeRequest request) {
        return employeeService.createEmployee(request);
    }


    /**
     * Retrieves employee from database through employee's unique pin in url path
     *
     *
     * @param pin unique employee id that is initialized in createEmployee method
     * @return employee that matches @param id
     */
    @GetMapping("{pin}")
    public EmployeeResponse getEmployee(@PathVariable int pin) {
        return employeeService.getEmployee(pin);
    }

    /**
     * Retrieves a list of ALL employees
     *
     *
     * @return a list of EmployeeResponse objects per employee
     */
    @GetMapping
    public List<EmployeeResponse> getAllEmployees() {
        return employeeService.getAllEmployees();
    }


}
