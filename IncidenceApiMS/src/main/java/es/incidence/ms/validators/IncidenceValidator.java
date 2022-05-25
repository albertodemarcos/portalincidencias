package es.incidence.ms.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.incidence.ms.utils.dtos.IncidenceDto;
import net.logstash.logback.util.StringUtils;

@Component
public class IncidenceValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return IncidenceDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		IncidenceDto incidenceDto = (IncidenceDto) target;
		
		if( incidenceDto == null ) 
		{
			errors.reject("INCIDENCE_VALIDATE.ERROR", null, "The incidence is null" );
			return;
		}
		
		if( StringUtils.isBlank( incidenceDto.getTitle() ) ) {
			errors.rejectValue("","INCIDENCE_VALIDATE.ERROR", null, "" );
		}
		
		if( StringUtils.isBlank( incidenceDto.getDescription() ) ) {
			errors.rejectValue("","INCIDENCE_VALIDATE.ERROR", null, "" );
		}
		
		if( incidenceDto.getStartDate() == null ) {
			errors.rejectValue("","INCIDENCE_VALIDATE.ERROR", null, "" );
		}
		
		if( incidenceDto.getEndDate() == null ) {
			errors.rejectValue("","INCIDENCE_VALIDATE.ERROR", null, "" );
		}
		
		if( incidenceDto.getLongitude() == null ) {
			errors.rejectValue("","INCIDENCE_VALIDATE.ERROR", null, "" );
		}
		
		if( incidenceDto.getLatitude() == null ) {
			errors.rejectValue("","INCIDENCE_VALIDATE.ERROR", null, "" );
		}
		
		if( incidenceDto.getOrganizationId() == null ) {
			errors.rejectValue("","INCIDENCE_VALIDATE.ERROR", null, "" );
		}
		
		if( incidenceDto.getCitizenId() == null ) {
			errors.rejectValue("","INCIDENCE_VALIDATE.ERROR", null, "" );
		}
		
		if( incidenceDto.getEmployeeId() == null ) {
			errors.rejectValue("","INCIDENCE_VALIDATE.ERROR", null, "" );
		}
	}

}
