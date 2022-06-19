package es.incidence.ms.service;

import java.util.Date;

import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;

import es.incidence.ms.domain.dtos.IncidenceDTO;
import es.incidence.ms.domain.dtos.IncidenceFilterDTO;
import es.incidence.ms.domain.entities.incidences.Incidence;
import es.incidence.ms.domain.entities.users.impl.Employee;
import es.incidence.ms.utils.ActionResponse;


public interface IIncidenceService {

	ActionResponse getIncidence(final Incidence incidence);
	
	ActionResponse createIncidence(final IncidenceDTO incidenceDTO, BindingResult result);
		
	ActionResponse deleteIncidence(final Long incidenceId);
	
	ActionResponse getIncidences(final Long citizenId, final Long organizationId, final IncidenceFilterDTO incidenceFilterDTO, Pageable page );
	
	ActionResponse getResolveIncident(Incidence incidence, final Employee employee, final Date endDate);
	
	ActionResponse getIncidencesCitizen(final Long citizenId, final Long organizationId );
}
