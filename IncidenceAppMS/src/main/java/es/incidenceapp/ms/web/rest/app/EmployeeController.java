package es.incidenceapp.ms.web.rest.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.incidenceapp.ms.domain.dtos.ActionResponse;
import es.incidenceapp.ms.domain.dtos.EmployeeDTO;
import es.incidenceapp.ms.domain.dtos.EmployeeFilterDTO;

@RestController
@RequestMapping(path = {"/employeesAppApi"})
public class EmployeeController {

private final Logger logger = LoggerFactory.getLogger( this.getClass() );
	
	
	@GetMapping(path = {"/employee/{employeeId}"})
	public ActionResponse getEmployee(@PathVariable Long employeeId) {
		
		logger.info("Method: EmployeeController.getEmployee(employeeId={})", employeeId != null ? employeeId : null );
		ActionResponse response = null;
		return response;
	}
	
	@GetMapping(path = {"/employee/{employeeId}"})
	public ActionResponse getEditEmployee(@PathVariable Long employeeId) {
		
		logger.info("Method: EmployeeController.getEditEmployee(employeeId={})", employeeId != null ? employeeId : null );
		ActionResponse response = null;
		return response;
	}

	@PostMapping(path = {"/createOrganization"})
	public ActionResponse postCreateEmployee(@RequestBody(required = true) EmployeeDTO employeeDTO, BindingResult result) {
		
		logger.info("Method: EmployeeController.postCreateEmployee(employeeDTO={})", (employeeDTO != null ? employeeDTO.toString():null) );
		
		ActionResponse response = null;

		return response;
	}
	
	@DeleteMapping(path = {"/employee/{organizationId}"})
	public ActionResponse getDeleteEmployee(@PathVariable Long employeeId) {
		
		logger.info("Method: EmployeeController.getDeleteEmployee(employeeId={})", employeeId != null ? employeeId : null );
		ActionResponse response = null;
		return response;
	}
	
	@GetMapping(path = {"/employees"})
	public ActionResponse getListEmployees(@RequestBody(required = true) final EmployeeFilterDTO employeeFilterDTO, @ModelAttribute Pageable page) {
		
		logger.info("Method: EmployeeController.getListEmployees(employeeFilterDTO={})", (employeeFilterDTO !=null ? employeeFilterDTO.toString() : null ) );
		ActionResponse response = null;
		return response;
	}
	
}
