package es.incidence.ms.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.incidence.ms.domain.dtos.OrganizationListDTO;
import es.incidence.ms.utils.filters.impl.OrganizationFilter;

public interface OrganizationCustomRepository {
	
	
	Page<OrganizationListDTO> getOrganizationsByFilter(final OrganizationFilter organizationFilter, Pageable page);

}
