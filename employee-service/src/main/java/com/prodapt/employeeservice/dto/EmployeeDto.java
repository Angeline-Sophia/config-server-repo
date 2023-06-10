package com.prodapt.employeeservice.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDto {
    private Long Id;
    private String firstName;
    private String lastName;
    private String email;
    private String departmentCode;
    private String organizationCode;
}
