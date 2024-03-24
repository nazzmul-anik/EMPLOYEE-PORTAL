package com.example.employee.portal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Employee Table")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Employee Id")
    private Long id;
    @Column(name ="Employee Name")
    private String name;
    @Column(name = "Employee Phone Number")
    private String phoneNumber;
    @Column(name = "Employee Designation")
    private String designation;
}
