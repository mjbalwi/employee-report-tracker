package com.mjbalwi.employee_tracker.dto.request;

import lombok.Data;
import lombok.AllArgsConstructor;
import  lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReportRequest {
    private String content;
}
