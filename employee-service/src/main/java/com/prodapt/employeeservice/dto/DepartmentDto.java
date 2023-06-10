package com.prodapt.employeeservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DepartmentDto {

    private Long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
