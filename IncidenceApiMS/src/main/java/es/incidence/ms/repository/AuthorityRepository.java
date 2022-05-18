package es.incidence.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.incidence.ms.domain.entities.users.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
