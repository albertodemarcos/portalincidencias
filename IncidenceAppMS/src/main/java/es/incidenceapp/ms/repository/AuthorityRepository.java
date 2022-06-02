package es.incidenceapp.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.incidenceapp.ms.domain.entities.users.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
