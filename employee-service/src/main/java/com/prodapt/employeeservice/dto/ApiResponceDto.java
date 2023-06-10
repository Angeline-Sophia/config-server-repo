package com.prodapt.employeeservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApiResponceDto {
    private EmployeeDto employeeDto;
    private DepartmentDto departmentDto;
    private OrganizationDto organizationDto;
}
