package es.incidence.ms.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.incidence.ms.domain.dtos.OrganizationFilterDTO;
import es.incidence.ms.domain.dtos.OrganizationListDTO;

public interface OrganizationCustomRepository {
	
	
	Page<OrganizationListDTO> getOrganizationsByFilter(final OrganizationFilterDTO organizationFilterDTO, Pageable page);

}
