package es.incidenceapp.ms.service.app.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import es.incidenceapp.ms.components.HttpMicroserviceService;
import es.incidenceapp.ms.components.MicroserviceConstans;
import es.incidenceapp.ms.domain.dtos.ActionResponse;
import es.incidenceapp.ms.domain.dtos.EmployeeDTO;
import es.incidenceapp.ms.domain.dtos.EmployeeFilterDTO;
import es.incidenceapp.ms.service.app.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {
	
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );
	
	@Autowired
	private HttpMicroserviceService httpMicroserviceService;

	@Override
	public ActionResponse getEmployee(Long employeeDTOId) {
		// TODO Auto-generated method stub
		logger.info("Method: EmployeeService.getEmployee(employeeDTOId={})", employeeDTOId);
		
		if( employeeDTOId == null || employeeDTOId <= 0L) 
		{
			logger.error("The employeeDTOId has defects. employeeDTOId={}", employeeDTOId);
			
			return new ActionResponse(MicroserviceConstans.NOK, "The employeeDTOId has not ID" );
		}
		
		ActionResponse _response = this.httpMicroserviceService.getEntity(employeeDTOId, MicroserviceConstans.PORTAL_INCIDENCE, MicroserviceConstans.EMPLOYEE);
		
		logger.info("End Method: EmployeeService.getEmployee(employeeDTOId={}). Result: {}", employeeDTOId, _response.getCode() );
		
		return _response;
	}

	@Override
	public ActionResponse createEmployee(EmployeeDTO employeeDTO, BindingResult result) {
		// TODO Auto-generated method stub
		logger.info("Method: EmployeeService.createEmployee(employeeDTO={})", employeeDTO != null ? employeeDTO.toString() : null );
		
		if( employeeDTO == null ) {

			logger.error("The employeeDTO has defects. Error={}", result.getFieldErrors().toString());
			
			return new ActionResponse(MicroserviceConstans.NOK, "The employeeDTO has defects.", result.getFieldErrors().toString() );
		}
		
		ActionResponse _response = this.httpMicroserviceService.saveEntity(employeeDTO, MicroserviceConstans.PORTAL_INCIDENCE, MicroserviceConstans.EMPLOYEE);
		
		logger.info("End Method: EmployeeService.createEmployee(employeeDTO={}). Result: {}", employeeDTO != null ? employeeDTO.toString() : null, _response.getCode() );
		
		return _response;
	}

	@Override
	public ActionResponse deleteEmployeeId(Long employeeDTOId) {
		// TODO Auto-generated method stub
		logger.info("Method: EmployeeService.deleteEmployeeId(employeeDTOId={})", employeeDTOId);
		
		if( employeeDTOId == null || employeeDTOId <= 0L) 
		{
			logger.error("The employeeDTOId has defects. employeeDTOId={}", employeeDTOId);
			
			return new ActionResponse(MicroserviceConstans.NOK, "The employeeDTOId has not ID" );
		}
		
		ActionResponse _response = this.httpMicroserviceService.deleteEntity(employeeDTOId, MicroserviceConstans.PORTAL_INCIDENCE, MicroserviceConstans.EMPLOYEE);
		
		logger.info("End Method: EmployeeService.deleteEmployeeId(employeeDTOId={}). Result: {}", employeeDTOId, _response.getCode() );
		
		return _response;
	}

	@Override
	public ActionResponse getEmployees(EmployeeFilterDTO employeeFilterDTO) {
		// TODO Auto-generated method stub
		logger.info("Method: EmployeeService.getEmployees(employeeFilterDTO={})", employeeFilterDTO != null ? employeeFilterDTO.toString() : null );
		
		if( employeeFilterDTO == null ) {

			logger.error("The employeeFilterDTO has defects");
			
			return new ActionResponse(MicroserviceConstans.NOK, "The employeeFilterDTO has defects." );
		}
		
		ActionResponse _response = this.httpMicroserviceService.listEntities(employeeFilterDTO, MicroserviceConstans.PORTAL_INCIDENCE, MicroserviceConstans.EMPLOYEE);
		
		logger.info("End Method: EmployeeService.getEmployees(employeeFilterDTO={}). Result: {}", employeeFilterDTO != null ? employeeFilterDTO.toString() : null, _response.getCode() );
		
		return _response;
	}


}
