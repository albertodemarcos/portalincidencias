package es.incidence.ms.service;

import org.springframework.validation.BindingResult;

import es.incidence.ms.utils.ActionResponse;
import es.incidence.ms.utils.dtos.IncidenceDto;
import es.incidence.ms.utils.filters.impl.IncidenceFilter;


public interface IIncidenceService {

	ActionResponse getIncidence(final Long incidenceId);
	
	ActionResponse createIncidence(final IncidenceDto incidenceDto, BindingResult result);
		
	ActionResponse deleteIncidence(final Long incidenceId);
	
	ActionResponse getIncidences(final IncidenceFilter incidenceFilter );
	
	
}
