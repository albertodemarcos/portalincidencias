package es.incidence.ms.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.incidence.ms.utils.dtos.IncidenceListDto;
import es.incidence.ms.utils.filters.impl.IncidenceFilter;

public interface IncidenceCustomRepository {

	
	Page<IncidenceListDto> getIncidencesByFilter(final Long citizenId, final Long organizationId, final IncidenceFilter incidenceFilter, Pageable page);		
		
	
}
