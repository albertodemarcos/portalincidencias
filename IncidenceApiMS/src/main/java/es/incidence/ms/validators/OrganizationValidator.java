package es.incidence.ms.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.incidence.ms.domain.dtos.OrganizationDTO;
import net.logstash.logback.util.StringUtils;

@Component
public class OrganizationValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return OrganizationDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		OrganizationDTO organizationDTO = (OrganizationDTO) target;
		
		if( organizationDTO == null ) 
		{
			errors.reject("INCIDENCE_VALIDATE.ERROR", null, "The organizationDTO is null" );
			return;
		}
		
		if( StringUtils.isBlank( organizationDTO.getName() ) ) {
			errors.rejectValue("","INCIDENCE_VALIDATE.ERROR", null, "" );
		}
		
		if( StringUtils.isBlank( organizationDTO.getDescription() ) ) {
			errors.rejectValue("","INCIDENCE_VALIDATE.ERROR", null, "" );
		}
		
		if( organizationDTO.getType() == null ) {
			errors.rejectValue("","INCIDENCE_VALIDATE.ERROR", null, "" );
		}
		
		if( organizationDTO.getLongitude() == null ) {
			errors.rejectValue("","INCIDENCE_VALIDATE.ERROR", null, "" );
		}
		
		if( organizationDTO.getLatitude() == null ) {
			errors.rejectValue("","INCIDENCE_VALIDATE.ERROR", null, "" );
		}
	}

}
