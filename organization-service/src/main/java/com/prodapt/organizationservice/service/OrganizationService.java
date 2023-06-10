package com.prodapt.organizationservice.service;

import com.prodapt.organizationservice.dto.OrganizationDto;
import com.prodapt.organizationservice.entity.Organization;

public interface OrganizationService {

    OrganizationDto saveOrganizationDto(OrganizationDto organizationDto);
    OrganizationDto getOrganization(String OrganizationCode);
}
