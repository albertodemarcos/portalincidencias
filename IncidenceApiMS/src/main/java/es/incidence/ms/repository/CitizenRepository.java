package es.incidence.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.incidence.ms.domain.entities.users.impl.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {

}
