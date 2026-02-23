package com.mjbalwi.employee_tracker.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class DailyActivityReport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private LocalDate date;
    private String content;
    private DARStatus status;

    protected DailyActivityReport() {}

    public DailyActivityReport(Employee employee, String content, DARStatus status, LocalDate date) {
        this.employee = employee;
        this.content = content;
        this.status = status;
        this.date = date;
    }

    //getters and setters
    public Long getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public DARStatus getStatus() {
        return status;
    }
}
