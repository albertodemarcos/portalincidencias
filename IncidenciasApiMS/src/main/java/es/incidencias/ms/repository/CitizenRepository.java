package es.incidencias.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.incidencias.ms.domain.entities.users.portal.impl.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {

}
