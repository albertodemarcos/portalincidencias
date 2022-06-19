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

import es.incidence.ms.domain.dtos.EmployeeFilterDTO;
import es.incidence.ms.domain.dtos.EmployeeListDTO;
import es.incidence.ms.repository.EmployeeCustomRepository;
import es.incidence.ms.utils.querys.impl.QueryResolvedService;

public class EmployeeRepositoryImpl implements EmployeeCustomRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired 
	private QueryResolvedService queryResolvedService;

	@SuppressWarnings("unchecked")
	@Override
	public Page<EmployeeListDTO> getEmployeesByFilter(final Long organizationId, final EmployeeFilterDTO employeeFilterDTO, Pageable page) {
		// TODO Auto-generated method stub
		String from = " from Employee e inner join e.organization o";
		
		String selectSqlQuery = " select new es.incidence.ms.domain.dtos.EmployeeListDTO() " + from;
		
		String countSqlQuery = " select count(i.id) " + from;
		
		Map<String, Object> sqlParamsQuery = new HashMap<String, Object>(5);
		
		long numRegister = queryResolvedService.countJpqlConsulterWithConditionExpression(em.createQuery(countSqlQuery), sqlParamsQuery);
		
		Page<EmployeeListDTO> employeeListDTO = null;
		
		if( numRegister > 0 ) 
		{
			Query query = queryResolvedService.getJpqlConsuslterWithSqlStr(selectSqlQuery, page, em, sqlParamsQuery);
			
			employeeListDTO = new PageImpl<EmployeeListDTO>(query.getResultList(), page, numRegister);
		} 
		else 
		{
			List<EmployeeListDTO> resultList = new ArrayList<EmployeeListDTO>(0);
			employeeListDTO = new PageImpl<EmployeeListDTO>(resultList, page, 0);
		}
		
		return employeeListDTO;
	}

}
