package com.mjbalwi.employee_tracker.dto.response;

import com.mjbalwi.employee_tracker.entities.ReportStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportResponse {
    private Long id;
    private int employeePin;
    private String employeeFirstName;
    private String employeeLastName;
    private LocalDate date;
    private String content;
    private ReportStatus status;
}