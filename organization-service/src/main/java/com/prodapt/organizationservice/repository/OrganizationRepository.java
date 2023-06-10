package com.prodapt.organizationservice.repository;

import com.prodapt.organizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization,Long> {
    Organization findByOrganizationCode(String OrganizationCode);
}
