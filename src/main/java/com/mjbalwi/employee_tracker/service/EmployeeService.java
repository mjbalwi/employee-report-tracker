package com.mjbalwi.employee_tracker.service;

import com.mjbalwi.employee_tracker.dto.request.CreateEmployeeRequest;
import com.mjbalwi.employee_tracker.dto.response.EmployeeResponse;
import com.mjbalwi.employee_tracker.entities.Employee;
import com.mjbalwi.employee_tracker.mapper.EmployeeMapper;
import com.mjbalwi.employee_tracker.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional //ensures db transaction
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Creates an employee and stores it in DB
     *
     * Use DTOs to prevent serialization loop
     *
     * @param request
     * @return
     */
    public EmployeeResponse createEmployee(CreateEmployeeRequest request) {
        Employee employee = new Employee();
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmail(request.getEmail());
        employee.setPin(request.getPin());
        employee.setRole(request.getRole());
        employeeRepository.save(employee);

        return EmployeeMapper.toResponse(employee);
    }


    /**
     * Get employee from DB
     *
     * @param pin unique employee pin that is assigned when employee is created
     * @return an EmployeeResponse object of that employee to display what is necessary to client
     */
    public EmployeeResponse getEmployee(int pin) {
        Employee employee = employeeRepository.findByPin(pin)
            .orElseThrow(() -> new RuntimeException("Employee not found with pin: " + pin));
        return EmployeeMapper.toResponse(employee);
    }

    /**
     * TODO what the hell is going on here jarvis?
     *
     * @return
     */
    public List<EmployeeResponse> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponse> responses = new ArrayList<>();

        for (Employee employee : employees) {
            responses.add(EmployeeMapper.toResponse(employee));
        }

        return responses;
    }

}
