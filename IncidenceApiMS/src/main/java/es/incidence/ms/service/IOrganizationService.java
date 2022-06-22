package es.incidence.ms.service;

import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;

import es.incidence.ms.domain.dtos.OrganizationDTO;
import es.incidence.ms.domain.dtos.OrganizationFilterDTO;
import es.incidence.ms.domain.entities.organizations.impl.Organization;
import es.incidence.ms.utils.ActionResponse;

public interface IOrganizationService {
	
	ActionResponse getOrganization(final Organization organization);
	
	ActionResponse createOrganization(final OrganizationDTO organizationDTO, BindingResult result);
		
	ActionResponse deleteOrganization(final Long organizationId);
	
	ActionResponse postOrganizations(final OrganizationFilterDTO organizationFilterDTO, Pageable page );
}
