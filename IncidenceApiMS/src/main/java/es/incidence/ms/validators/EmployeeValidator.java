package es.incidence.ms.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.incidence.ms.domain.dtos.EmployeeDTO;
import es.incidence.ms.domain.dtos.OrganizationDTO;
import net.logstash.logback.util.StringUtils;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return EmployeeDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		EmployeeDTO employeeDTO = (EmployeeDTO) target;
		
		if( employeeDTO == null ) 
		{
			errors.reject("INCIDENCE_VALIDATE.ERROR", null, "The employeeDTO is null" );
			return;
		}
		
		if( StringUtils.isBlank( employeeDTO.getFirstName() ) ) {
			errors.rejectValue("","INCIDENCE_VALIDATE.ERROR", null, "" );
		}
		
		if( StringUtils.isBlank( employeeDTO.getLastName() ) ) {
			errors.rejectValue("","INCIDENCE_VALIDATE.ERROR", null, "" );
		}
		
		if( employeeDTO.getEmail() == null ) {
			errors.rejectValue("","INCIDENCE_VALIDATE.ERROR", null, "" );
		}
		
		if( employeeDTO.getLogin() == null ) {
			errors.rejectValue("","INCIDENCE_VALIDATE.ERROR", null, "" );
		}
		
		if( employeeDTO.getAlias() == null ) {
			errors.rejectValue("","INCIDENCE_VALIDATE.ERROR", null, "" );
		}
	}

}
