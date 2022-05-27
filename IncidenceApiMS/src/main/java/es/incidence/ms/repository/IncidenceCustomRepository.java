package es.incidence.ms.repository;

import org.springframework.data.domain.Page;

import es.incidence.ms.utils.dtos.IncidenceDto;
import es.incidence.ms.utils.filters.impl.IncidenceFilter;

public interface IncidenceCustomRepository {

	
	Page<IncidenceDto> getIncidencesByFilter(final Long citizenId, final Long organizationId, final IncidenceFilter incidenceFilter);		
		
	
}
