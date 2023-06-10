package com.prodapt.employeeservice.service;

import com.prodapt.employeeservice.dto.DepartmentDto;
import com.prodapt.employeeservice.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:9090/",name = "DEPARTMENT-SERVICE")
@FeignClient(name = "ORGANIZATION-SERVICE")
public interface OrganizationAPIClient {

    @GetMapping("api/organization/get/{code}")
    public OrganizationDto getOrganizationByCode(@PathVariable("code") String organizationCode);
}
