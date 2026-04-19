
package com.mjbalwi.employee_tracker.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int pin;

    /**
     * JPA defaults to EnumType.ORDINAL which stores enum position.
     * This makes adding new entry point to wrong role later down the line if between existing enums
     * By changing type to String, it is no longer tied to position and safe to reorder
     */
    @Enumerated(EnumType.STRING)
    private Role role;



    @JsonIgnore
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)    //one employee has many reports -->
    private List<Report> reports;

}
