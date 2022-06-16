package es.incidence.ms.web.rest.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.incidence.ms.domain.dtos.EmployeeDTO;
import es.incidence.ms.domain.dtos.EmployeeFilterDTO;
import es.incidence.ms.domain.entities.users.impl.Employee;
import es.incidence.ms.service.impl.EmployeeService;
import es.incidence.ms.utils.ActionResponse;
import es.incidence.ms.validators.EmployeeValidator;

@RestController
@RequestMapping(path = {"/employeeApi"})
public class EmployeeController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private EmployeeValidator employeeValidator;
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping(path = {"/employee/{employee}"})
	public ActionResponse getOrganization(@PathVariable Employee employee) 
	{
		logger.info("Method: EmployeesController.getEmployee(employee={})", employee != null ? employee.getId() : null );
		ActionResponse response = this.employeeService.getEmployee(employee);
		return response;
	}
	
	@PostMapping(path = {"/createEmployee"})
	public ActionResponse createEmployee(@RequestBody(required = true) EmployeeDTO employeeDTO, BindingResult result) 
	{
		logger.info("Method: EmployeesController.createEmployee(employeeDTO={})", (employeeDTO!=null ? employeeDTO.toString():null) );
		
		employeeValidator.validate(employeeDTO, result);
		
		if( result.hasErrors() ) {
			
			return new ActionResponse("-1", null, result.getAllErrors() );
		}
		
		ActionResponse response = this.employeeService.createEmployee(employeeDTO, result);

		return response;
	}
		
	@DeleteMapping(path = {"/employee/{employee}"})
	public ActionResponse deleteEmployee(@PathVariable Long employeeId, @PathVariable Long organizationId) 
	{
		logger.info("Method: EmployeesController.deleteEmployeeById(employeeId={}, organizationId={})", employeeId, organizationId );
		ActionResponse response = this.employeeService.deleteEmployee(employeeId, organizationId);
		return response;
	}
	
	@GetMapping(path = {"/employees"})
	public ActionResponse getEmployees(@RequestParam(required = true) final Long organizationId, @RequestBody(required = true) final EmployeeFilterDTO employeeFilterDTO, @ModelAttribute Pageable page)
	{
		logger.info("Method: EmployeesController.getEmployees(employeeFilter={})", (employeeFilterDTO !=null ? employeeFilterDTO.toString() : null ) );
		ActionResponse response = this.employeeService.getEmployees(organizationId, employeeFilterDTO, page);
		return response;
	}


}
