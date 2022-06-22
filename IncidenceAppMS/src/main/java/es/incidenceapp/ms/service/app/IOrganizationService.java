package es.incidenceapp.ms.service.app;

import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;

import es.incidenceapp.ms.domain.dtos.ActionResponse;
import es.incidenceapp.ms.domain.dtos.OrganizationDTO;
import es.incidenceapp.ms.domain.dtos.OrganizationFilterDTO;


public interface IOrganizationService {

	ActionResponse getOrganization(final Long organizationDTOId);
	
	ActionResponse createOrganization(final OrganizationDTO organizationDTO, BindingResult result);

	ActionResponse deleteOrganizationId(final Long organizationDTOId);
	
	ActionResponse postOrganizations(final OrganizationFilterDTO organizationFilterDTO, Pageable page);
	
}
