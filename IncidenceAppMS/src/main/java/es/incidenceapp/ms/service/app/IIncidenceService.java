package es.incidenceapp.ms.service.app;

import org.springframework.validation.BindingResult;

import es.incidenceapp.ms.domain.dtos.ActionResponse;
import es.incidenceapp.ms.domain.dtos.IncidenceDTO;
import es.incidenceapp.ms.domain.dtos.IncidenceFilterDTO;

public interface IIncidenceService {

	ActionResponse getIncidence(final Long incidenceDTOId);
	
	ActionResponse createIncidence(final IncidenceDTO incidenceDTO, BindingResult result);

	ActionResponse deleteIncidenceId(final Long incidenceDTOId);
	
	ActionResponse getIncidences(final IncidenceFilterDTO incidenceFilterDTO);
	
}
