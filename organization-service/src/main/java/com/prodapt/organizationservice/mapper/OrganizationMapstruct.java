package com.prodapt.organizationservice.mapper;

import com.prodapt.organizationservice.dto.OrganizationDto;
import com.prodapt.organizationservice.entity.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrganizationMapstruct {

    OrganizationMapstruct ORGANIZATION_MAPSTRUCT = Mappers.getMapper(OrganizationMapstruct.class);

    OrganizationDto convertEntityToDto(Organization organization);

    Organization convertDtoToEntity(OrganizationDto organizationDto);


}
