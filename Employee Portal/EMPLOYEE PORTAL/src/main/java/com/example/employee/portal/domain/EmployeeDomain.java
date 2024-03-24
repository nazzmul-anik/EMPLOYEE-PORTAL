package com.example.employee.portal.domain;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDomain {
    private String name;
    private String designation;
    private String phoneNumber;
}
