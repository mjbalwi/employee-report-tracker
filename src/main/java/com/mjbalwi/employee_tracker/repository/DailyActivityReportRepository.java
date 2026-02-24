package com.mjbalwi.employee_tracker.repository;

import com.mjbalwi.employee_tracker.entities.DailyActivityReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyActivityReportRepository extends JpaRepository<DailyActivityReport, Long> {

}
