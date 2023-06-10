package com.prodapt.organizationservice.service.impl;

import com.prodapt.organizationservice.dto.OrganizationDto;
import com.prodapt.organizationservice.entity.Organization;
import com.prodapt.organizationservice.mapper.OrganizationMapstruct;
import com.prodapt.organizationservice.repository.OrganizationRepository;
import com.prodapt.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository repository;

    @Override
    public OrganizationDto saveOrganizationDto(OrganizationDto organizationDto) {

        Organization organization = OrganizationMapstruct.ORGANIZATION_MAPSTRUCT.convertDtoToEntity(organizationDto);
        return OrganizationMapstruct.ORGANIZATION_MAPSTRUCT.convertEntityToDto(repository.save(organization));
    }

    @Override
    public OrganizationDto getOrganization(String organizationCode) {
        Organization organizationFromDb = repository.findByOrganizationCode(organizationCode);
        return OrganizationMapstruct.ORGANIZATION_MAPSTRUCT.convertEntityToDto(organizationFromDb);
    }
}
