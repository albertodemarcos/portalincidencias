package es.incidence.ms.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.incidence.ms.domain.dtos.IncidenceFilterDTO;
import es.incidence.ms.domain.dtos.IncidenceListDTO;

public interface IncidenceCustomRepository {

	
	Page<IncidenceListDTO> getIncidencesByFilter(final Long citizenId, final Long organizationId, final IncidenceFilterDTO incidenceFilterDTO, Pageable page);		
		
	
}
