package es.incidenceapp.ms.service.app;

import org.springframework.validation.BindingResult;

import es.incidenceapp.ms.domain.dtos.ActionResponse;
import es.incidenceapp.ms.domain.dtos.EmployeeDTO;
import es.incidenceapp.ms.domain.dtos.EmployeeFilterDTO;

public interface IEmployeeService {

	ActionResponse getEmployee(final Long employeeDTOId);
	
	ActionResponse createEmployee(final EmployeeDTO employeeDTO, BindingResult result);

	ActionResponse deleteEmployeeId(final Long employeeDTOId);
	
	ActionResponse getEmployees(final EmployeeFilterDTO employeeFilterDTO);
}
