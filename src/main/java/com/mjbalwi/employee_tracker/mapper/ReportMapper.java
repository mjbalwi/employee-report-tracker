package com.mjbalwi.employee_tracker.mapper;

import com.mjbalwi.employee_tracker.dto.response.ReportResponse;
import com.mjbalwi.employee_tracker.entities.Report;

public class ReportMapper {

    public static ReportResponse toResponse(Report report) {
        return new ReportResponse(
            report.getId(),
            report.getEmployee().getPin(),
            report.getEmployee().getFirstName(),
            report.getEmployee().getLastName(),
            report.getDate(),
            report.getContent(),
            report.getStatus()
        );
    }
}