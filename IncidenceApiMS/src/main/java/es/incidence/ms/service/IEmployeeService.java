package es.incidence.ms.service;

import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;

import es.incidence.ms.domain.dtos.EmployeeDTO;
import es.incidence.ms.domain.dtos.EmployeeFilterDTO;
import es.incidence.ms.domain.entities.users.impl.Employee;
import es.incidence.ms.utils.ActionResponse;

public interface IEmployeeService {
	
	ActionResponse getEmployee(final Employee employee);
	
	ActionResponse createEmployee(final EmployeeDTO employeeDTO, BindingResult result);
		
	ActionResponse deleteEmployee(final Long employeeId, final Long organizationId);
	
	ActionResponse getEmployees(final Long organizationId, final EmployeeFilterDTO employeeFilterDTO, Pageable page );

}
