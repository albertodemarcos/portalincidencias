package es.incidence.ms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.incidence.ms.domain.entities.users.impl.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {

	
	Optional<Citizen> findByIdAndOrganizationId(Long id, Long organizationId);
}
