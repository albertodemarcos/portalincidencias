package es.incidencias.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.incidencias.ms.domain.entities.organization.impl.TownHall;

public interface TownHallRepository extends JpaRepository<TownHall, Long> {

}
