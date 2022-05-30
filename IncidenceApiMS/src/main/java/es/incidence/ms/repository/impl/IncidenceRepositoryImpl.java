package es.incidence.ms.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import es.incidence.ms.repository.IncidenceCustomRepository;
import es.incidence.ms.utils.dtos.IncidenceListDto;
import es.incidence.ms.utils.filters.impl.IncidenceFilter;
import es.incidence.ms.utils.querys.impl.QueryResolvedService;

public class IncidenceRepositoryImpl implements IncidenceCustomRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired 
	private QueryResolvedService queryResolvedService;

	@SuppressWarnings("unchecked")
	@Override
	public Page<IncidenceListDto> getIncidencesByFilter(Long citizenId, Long organizationId, IncidenceFilter incidenceFilter, Pageable page) {
		// TODO Auto-generated method stub
		
		
		String from = " from Incidence i inner join i.citizen c inner left join i.employee e inner join i.organization o";
		
		String selectSqlQuery = " select new es.incidence.ms.utils.dtos.IncidenceListDto(i.id, i.title, i.description, i.startDate, i.endDate, i.longitude, i.latitude, o.id, c.id, e.id) "	+ from;
		
		String countSqlQuery = " select count(i.id) " + from;
		
		Map<String, Object> sqlParamsQuery = new HashMap<String, Object>(5);
		
		sqlParamsQuery.put("organizationId", organizationId);
		sqlParamsQuery.put("citizenId", citizenId);
		
		long numRegister = queryResolvedService.countJpqlConsulterWithConditionExpression(em.createQuery(countSqlQuery), sqlParamsQuery);
		
		Page<IncidenceListDto> incidencesDto = null;
		
		if( numRegister > 0 ) 
		{
			Query query = queryResolvedService.getJpqlConsuslterWithSqlStr(selectSqlQuery, page, em, sqlParamsQuery);
			
			incidencesDto = new PageImpl<IncidenceListDto>(query.getResultList(), page, numRegister);
		} 
		else 
		{
			List<IncidenceListDto> resultList = new ArrayList<IncidenceListDto>(0);
			incidencesDto = new PageImpl<IncidenceListDto>(resultList, page, 0);
		}
		
		return incidencesDto;
	}

}
