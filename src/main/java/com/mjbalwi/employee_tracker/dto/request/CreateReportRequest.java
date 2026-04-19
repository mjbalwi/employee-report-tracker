/**
 * File: CreateReportRequest.java
 * Description: DTO class for creating reports.
 * Contains necessary data fields for creating a report including employeePin, date, and report content
 *
 * Author: Majeed Balwi
 * Created: 2026-04-2026
 *
 * Version History:
 * v1.0-2026-04-11 - initial implementation
 *
 */

package com.mjbalwi.employee_tracker.dto.request;

import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateReportRequest {
    private int employeePin;
    private LocalDate date;
    private String content;
}
