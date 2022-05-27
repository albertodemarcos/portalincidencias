package es.incidence.ms.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import es.incidence.ms.repository.IncidenceCustomRepository;
import es.incidence.ms.utils.dtos.IncidenceDto;
import es.incidence.ms.utils.filters.impl.IncidenceFilter;
import es.incidence.ms.utils.querys.impl.QueryResolvedService;

public class IncidenceRepositoryImpl implements IncidenceCustomRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired 
	private QueryResolvedService queryResolvedService;

	@Override
	public Page<IncidenceDto> getIncidencesByFilter(Long citizenId, Long organizationId,
			IncidenceFilter incidenceFilter) {
		// TODO Auto-generated method stub
		
		
		queryResolvedService.countJpqlConsulterWithConditionExpression(null, null);
		
		
		
		return null;
	}

}
