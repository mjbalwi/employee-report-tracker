package com.mjbalwi.employee_tracker.entities;


import jakarta.persistence.*;

import java.util.List;

/*
* dars shorthand for Daily Activity Reports
 */

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private int pin;
    private Role role;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<DailyActivityReport> dars;

    protected Employee() {}

    public Employee(String firstName, String lastName, int pin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Role getRole() {
        return role;
    }

    public int getPin() {
        return pin;
    }

}
