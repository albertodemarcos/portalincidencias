package es.incidence.ms.converter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import es.incidence.ms.domain.entities.incidences.Incidence;
import es.incidence.ms.domain.entities.users.User;
import es.incidence.ms.repository.IncidenceRepository;

@Component
public class IncidenceConverter implements Converter<String, Incidence> {

	@Autowired
	private IncidenceRepository incidenceRepository;
	
	
	@Override
	public Incidence convert(String source) {
		// TODO Auto-generated method stub
		
		Long incidenceId = null;
		
		try {
			
			source = source.replaceAll("\\D+", "");
			incidenceId = Long.parseLong( source );
			
		} catch(IllegalArgumentException iae) {
			
			iae.printStackTrace();
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		Optional<Incidence> incidence = this.incidenceRepository.findByIdAndOrganizationId(incidenceId, user.getOrganization().getId());
		
		return incidence.orElse(null);
	}


	public void setIncidenceRepository(IncidenceRepository incidenceRepository) {
		this.incidenceRepository = incidenceRepository;
	}
	

}
