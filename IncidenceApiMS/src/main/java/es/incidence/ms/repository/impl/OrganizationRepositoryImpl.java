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

import es.incidence.ms.domain.dtos.OrganizationListDTO;
import es.incidence.ms.repository.OrganizationCustomRepository;
import es.incidence.ms.utils.filters.impl.OrganizationFilter;
import es.incidence.ms.utils.querys.impl.QueryResolvedService;

public class OrganizationRepositoryImpl implements OrganizationCustomRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired 
	private QueryResolvedService queryResolvedService;

	@SuppressWarnings("unchecked")
	@Override
	public Page<OrganizationListDTO> getOrganizationsByFilter(OrganizationFilter organizationFilter, Pageable page) {
		// TODO Auto-generated method stub
		String from = " from Incidence i inner join i.citizen c inner left join i.employee e inner join i.organization o";
		
		String selectSqlQuery = " select new es.incidence.ms.utils.dtos.IncidenceListDto(i.id, i.title, i.description, i.startDate, i.endDate, i.longitude, i.latitude, o.id, c.id, e.id) "	+ from;
		
		String countSqlQuery = " select count(i.id) " + from;
		
		Map<String, Object> sqlParamsQuery = new HashMap<String, Object>(5);
		
		long numRegister = queryResolvedService.countJpqlConsulterWithConditionExpression(em.createQuery(countSqlQuery), sqlParamsQuery);
		
		Page<OrganizationListDTO> organizationListDTO = null;
		
		if( numRegister > 0 ) 
		{
			Query query = queryResolvedService.getJpqlConsuslterWithSqlStr(selectSqlQuery, page, em, sqlParamsQuery);
			
			organizationListDTO = new PageImpl<OrganizationListDTO>(query.getResultList(), page, numRegister);
		} 
		else 
		{
			List<OrganizationListDTO> resultList = new ArrayList<OrganizationListDTO>(0);
			organizationListDTO = new PageImpl<OrganizationListDTO>(resultList, page, 0);
		}
		
		return organizationListDTO;
	}

}
