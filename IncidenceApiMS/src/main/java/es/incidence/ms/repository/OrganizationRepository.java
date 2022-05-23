package es.incidence.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.incidence.ms.domain.entities.organizations.impl.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long>{

}
