package com.mjbalwi.employee_tracker.service;

import com.mjbalwi.employee_tracker.dto.request.CreateReportRequest;
import com.mjbalwi.employee_tracker.dto.request.UpdateReportRequest;
import com.mjbalwi.employee_tracker.dto.response.ReportResponse;
import com.mjbalwi.employee_tracker.entities.Report;
import com.mjbalwi.employee_tracker.entities.ReportStatus;
import com.mjbalwi.employee_tracker.entities.Employee;
import com.mjbalwi.employee_tracker.mapper.ReportMapper;
import com.mjbalwi.employee_tracker.repository.EmployeeRepository;
import com.mjbalwi.employee_tracker.repository.ReportRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional //TODO what is transactional?
public class ReportService {

    private final ReportRepository reportRepository;
    private final EmployeeRepository employeeRepository;


    /**
     * instantiate repos for both report and employee
     *
     * @param reportRepository
     * @param employeeRepository
     */
    public ReportService(ReportRepository reportRepository, EmployeeRepository employeeRepository) {
        this.reportRepository = reportRepository;
        this.employeeRepository = employeeRepository;
    }

    /**
     * Create a report for the employee identified by the pin
     *
     * The report is saved with status PENDING by default. The employee
     * must already exist in database.
     *
     * @param request the request DTO containing employee pin, ddate, and report content
     * @return the saved report, mapped to a response DTO
     * @throws RuntimeException if no employee is found for given pin
     */
    public ReportResponse createReport(CreateReportRequest request) {
        Employee employee = employeeRepository.findByPin(request.getEmployeePin())
            .orElseThrow(() -> new RuntimeException("Employee not found with pin: " + request.getEmployeePin()));
        Report report = new Report(null, employee, request.getDate(), request.getContent(), ReportStatus.PENDING);


        return ReportMapper.toResponse(reportRepository.save(report));
    }

    /**
     * Updates content of an existing report
     *
     * Only the content of report is updated
     *
     * @param id reports db id
     * @param request update request DTO containing the new content
     * @return the updated report, mapped to a response DTO
     * @throws RuntimeException if no report is found for the given id
     */
    public ReportResponse updateReport(Long id, UpdateReportRequest request) {
        Report report = reportRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Report not found for id: " + id));

        report.setContent(request.getContent());
        return ReportMapper.toResponse(reportRepository.save(report));
    }

    /**
     * Retrieves report using employee pin and date
     *
     *
     * @param pin unique employee pin assigned at employee creation
     * @param date date of which the report was created
     * @return the matching report, mapped to response DTO
     * @throws RuntimeException if no report was found for the given pin and date
     */
    public ReportResponse getReport(int pin, LocalDate date) {
        Report report = reportRepository.findByEmployeePinAndDate(pin, date)
            .orElseThrow(() -> new RuntimeException("Report not found for pin: " + pin + " on " + date));

        return ReportMapper.toResponse(report);
    }

    /**
     * Retrieves all reports of a given employee identified by the employee pin
     *
     * @param employeePin unique employee pin number assigned to employee object at creation
     * @return a list of dto report response objects
     */
    public List<ReportResponse> getAllReportsByEmployee(int employeePin) {
        List<Report> reports = reportRepository.findReportByEmployeePin(employeePin);
        List<ReportResponse> responses = new ArrayList<>();

        for (Report report : reports) {
            responses.add(ReportMapper.toResponse(report));
        }

        return responses;
    }


}