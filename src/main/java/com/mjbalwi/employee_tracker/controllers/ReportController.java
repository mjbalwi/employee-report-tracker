package com.mjbalwi.employee_tracker.controllers;

import com.mjbalwi.employee_tracker.dto.response.ReportResponse;
import com.mjbalwi.employee_tracker.service.ReportService;
import com.mjbalwi.employee_tracker.dto.request.CreateReportRequest;
import com.mjbalwi.employee_tracker.dto.request.UpdateReportRequest;
import com.mjbalwi.employee_tracker.entities.Report;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping
    public ReportResponse createReport(@RequestBody CreateReportRequest request) {
       return reportService.createReport(request);
    }

    @PutMapping("/{id}")
    public ReportResponse updateReport(@PathVariable Long id, @RequestBody UpdateReportRequest request) {
        return reportService.updateReport(id, request);
    }

    @GetMapping("/{employeePin}/{date}")
    public ReportResponse getReport(@PathVariable int employeePin, @PathVariable LocalDate date) {
        return reportService.getReport(employeePin, date);
    }

    @GetMapping("/employee/{employeePin}")
    public List<ReportResponse> getAllReportsByEmployee(@PathVariable int employeePin) {
        return reportService.getAllReportsByEmployee(employeePin);
    }

}
