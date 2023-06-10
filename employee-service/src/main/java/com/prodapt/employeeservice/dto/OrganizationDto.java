package com.prodapt.employeeservice.dto;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrganizationDto {
    private Long id;
    private String organizationName;
    private String organizationCode;
    private String organizationDescription;
    private LocalDateTime createdDate;
}
