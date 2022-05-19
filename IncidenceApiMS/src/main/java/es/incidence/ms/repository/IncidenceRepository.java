package es.incidence.ms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.incidence.ms.domain.entities.incidences.Incidence;

public interface IncidenceRepository extends JpaRepository<Incidence, Long>{
	
	Optional<Incidence> findByIdAndOrganizationId(Long id, Long organizationId);

}
