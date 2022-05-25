package es.incidence.ms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.incidence.ms.domain.entities.users.impl.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Optional<Employee> findByIdAndOrganizationId(Long id, Long organizationId);
}
