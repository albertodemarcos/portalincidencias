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

import es.incidence.ms.domain.dtos.IncidenceFilterDTO;
import es.incidence.ms.domain.dtos.IncidenceListDTO;
import es.incidence.ms.repository.IncidenceCustomRepository;
import es.incidence.ms.utils.querys.impl.QueryResolvedService;

public class IncidenceRepositoryImpl implements IncidenceCustomRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired 
	private QueryResolvedService queryResolvedService;

	@SuppressWarnings("unchecked")
	@Override
	public Page<IncidenceListDTO> getIncidencesByFilter(Long citizenId, Long organizationId, IncidenceFilterDTO incidenceFilterDTO, Pageable page) {
		// TODO Auto-generated method stub
		
		
		String from = " from Incidence i inner join i.citizen c inner left join i.employee e inner join i.organization o";
		
		String selectSqlQuery = " select new es.incidence.ms.utils.dtos.IncidenceListDto(i.id, i.title, i.description, i.startDate, i.endDate, i.longitude, i.latitude, o.id, c.id, e.id) "	+ from;
		
		String countSqlQuery = " select count(i.id) " + from;
		
		Map<String, Object> sqlParamsQuery = new HashMap<String, Object>(5);
		
		sqlParamsQuery.put("organizationId", organizationId);
		sqlParamsQuery.put("citizenId", citizenId);
		
		long numRegister = queryResolvedService.countJpqlConsulterWithConditionExpression(em.createQuery(countSqlQuery), sqlParamsQuery);
		
		Page<IncidenceListDTO> incidencesDto = null;
		
		if( numRegister > 0 ) 
		{
			Query query = queryResolvedService.getJpqlConsuslterWithSqlStr(selectSqlQuery, page, em, sqlParamsQuery);
			
			incidencesDto = new PageImpl<IncidenceListDTO>(query.getResultList(), page, numRegister);
		} 
		else 
		{
			List<IncidenceListDTO> resultList = new ArrayList<IncidenceListDTO>(0);
			incidencesDto = new PageImpl<IncidenceListDTO>(resultList, page, 0);
		}
		
		return incidencesDto;
	}

}
