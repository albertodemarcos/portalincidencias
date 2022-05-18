package es.incidencias.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.incidencias.ms.domain.entities.Incidence;

public interface IncidenceRepository extends JpaRepository<Incidence, Long>{

}
