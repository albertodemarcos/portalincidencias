package es.incidence.ms.service;

import java.util.Date;

import org.springframework.validation.BindingResult;

import es.incidence.ms.domain.entities.incidences.Incidence;
import es.incidence.ms.domain.entities.users.impl.Employee;
import es.incidence.ms.utils.ActionResponse;
import es.incidence.ms.utils.dtos.IncidenceDto;
import es.incidence.ms.utils.filters.impl.IncidenceFilter;


public interface IIncidenceService {

	ActionResponse getIncidence(final Incidence incidence);
	
	ActionResponse createIncidence(final IncidenceDto incidenceDto, BindingResult result);
		
	ActionResponse deleteIncidence(final Long incidenceId);
	
	ActionResponse getIncidences(final IncidenceFilter incidenceFilter );
	
	ActionResponse getResolveIncident(Incidence incidence, final Employee employee, final Date endDate);
	
	ActionResponse getIncidencesCitizen(final Long citizenId, final Long organizationId );
}
