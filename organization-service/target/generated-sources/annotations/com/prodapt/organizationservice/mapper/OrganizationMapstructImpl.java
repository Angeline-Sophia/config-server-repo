package com.prodapt.organizationservice.mapper;

import com.prodapt.organizationservice.dto.OrganizationDto;
import com.prodapt.organizationservice.entity.Organization;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-23T11:48:19+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class OrganizationMapstructImpl implements OrganizationMapstruct {

    @Override
    public OrganizationDto convertEntityToDto(Organization organization) {
        if ( organization == null ) {
            return null;
        }

        OrganizationDto organizationDto = new OrganizationDto();

        organizationDto.setId( organization.getId() );
        organizationDto.setOrganizationName( organization.getOrganizationName() );
        organizationDto.setOrganizationCode( organization.getOrganizationCode() );
        organizationDto.setOrganizationDescription( organization.getOrganizationDescription() );
        organizationDto.setCreatedDate( organization.getCreatedDate() );

        return organizationDto;
    }

    @Override
    public Organization convertDtoToEntity(OrganizationDto organizationDto) {
        if ( organizationDto == null ) {
            return null;
        }

        Organization organization = new Organization();

        organization.setId( organizationDto.getId() );
        organization.setOrganizationName( organizationDto.getOrganizationName() );
        organization.setOrganizationCode( organizationDto.getOrganizationCode() );
        organization.setOrganizationDescription( organizationDto.getOrganizationDescription() );
        organization.setCreatedDate( organizationDto.getCreatedDate() );

        return organization;
    }
}
