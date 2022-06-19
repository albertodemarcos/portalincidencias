package es.incidence.ms.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.incidence.ms.domain.dtos.EmployeeFilterDTO;
import es.incidence.ms.domain.dtos.EmployeeListDTO;

public interface EmployeeCustomRepository {

	Page<EmployeeListDTO> getEmployeesByFilter(final Long organizationId, final EmployeeFilterDTO employeeFilterDTO, Pageable page);
}
