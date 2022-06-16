package es.incidence.ms.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import es.incidence.ms.domain.dtos.EmployeeDTO;
import es.incidence.ms.domain.dtos.EmployeeFilterDTO;
import es.incidence.ms.domain.dtos.EmployeeListDTO;
import es.incidence.ms.domain.entities.users.impl.Employee;
import es.incidence.ms.repository.EmployeeRepository;
import es.incidence.ms.service.IEmployeeService;
import es.incidence.ms.utils.ActionResponse;

@Service
public class EmployeeService implements IEmployeeService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public ActionResponse getEmployee(Employee employee) {
		// TODO Auto-generated method stub
		logger.info("Method: EmployeeService.getEmployee(employeeId={})", employee != null ? employee.getId() : null);
		
		if( employee == null) {
			
			logger.error("Method: EmployeeService.getEmployee(employeeId={}) has errors", employee != null ? employee.getId() : null);
			
			return new ActionResponse("1", "", null);
		}
		
		EmployeeDTO employeeDTO = this.populateEmployeeDTO(employee);
		
		return new ActionResponse("1", "", employeeDTO);
	}

	@Override
	public ActionResponse createEmployee(EmployeeDTO employeeDTO, BindingResult result) {
		// TODO Auto-generated method stub
		logger.info("Method: EmployeeService.createEmployee(employeeDTO={})", (employeeDTO!=null?employeeDTO.toString():null) );
		
		Employee employee = null;
		
		if( employeeDTO.isNew() ) {
			
			employee = new Employee();
			
		} else {
			
			employee = employeeRepository.findByIdAndOrganizationId(employeeDTO.getId(), employeeDTO.getOrganizationId() ).orElse(null);
			
			if( employee == null ) {
				
				return new ActionResponse("-1", "The employee don't exist");
			}
		}
		
		
		
		employeeRepository.save(employee);
		
		ActionResponse response = new ActionResponse("1", "The employee was created", employee );
				
		return response;
	}

	@Override
	public ActionResponse deleteEmployee(Long employeeId, Long organizationId) {
		// TODO Auto-generated method stub
		logger.info("Method: EmployeeService.deleteEmployee(employeeId={}, organizationId={})", employeeId, organizationId );
		
		ActionResponse response = null;
		
		if( employeeId == null ) {
			
			return new ActionResponse("-1", "Error! employeeId is null");
		}
		
		try
		{
			employeeRepository.deleteById(employeeId);
			
			response = new ActionResponse("1", "The employee was deleted");
		}
		catch(IllegalArgumentException iae) {
			
			logger.error("An error occurred while deleting the entity with id={} because the argument is not valid", employeeId);
			logger.error("Error: {}", iae.getMessage());
			
			response = new ActionResponse("-1", "The id argument is invalid");
		}
		catch(Exception e) {
			
			logger.error("An error occurred while deleting entity with id={}", employeeId);
			logger.error("Error: {}", e.getMessage());
			
			response = new ActionResponse("-1", "Error! The entity was not deleted");
		}
		
		return response;
	}

	@Override
	public ActionResponse getEmployees(Long employeeId, EmployeeFilterDTO employeeFilterDTO, Pageable page) {
		// TODO Auto-generated method stub
		logger.info("Method: EmployeeService.getEmployees(employeeFilterDTO={})", (employeeFilterDTO !=null ? employeeFilterDTO.toString() : null ) );
		
		Page<EmployeeListDTO> employeesPage = null;
		
		try {
		
			employeesPage = null;//employeeRepository.getOrganizationsByFilter(employeeFilterDTO, page);
			
			if( employeesPage == null ) {
				
				throw new Exception("There's not data");
			}
			
		} catch(Exception e) {
			
			logger.error("An error has occurred while obtaining the list of employees");
			
			logger.error("Error! {}", e.getMessage());
			
			return new ActionResponse("-1", "An error has occurred while obtaining the list of employees");
		}
		
		ActionResponse actionResponse = new ActionResponse("1", null, employeesPage);
		
		return actionResponse;
	}

	private EmployeeDTO populateEmployeeDTO(Employee employee) {
		
		return null;
	}
	
}
