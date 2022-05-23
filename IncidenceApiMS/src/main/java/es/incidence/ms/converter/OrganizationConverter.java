package es.incidence.ms.converter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import es.incidence.ms.domain.entities.organizations.impl.Organization;
//import es.incidence.ms.domain.entities.users.User;
import es.incidence.ms.repository.OrganizationRepository;

@Component
public class OrganizationConverter implements Converter<String, Organization> {

	@Autowired
	private OrganizationRepository organizationRepository;
	
	
	@Override
	public Organization convert(String source) {
		// TODO Auto-generated method stub
		Long organizationId = null;
		
		try {
			
			source = source.replaceAll("\\D+", "");
			organizationId = Long.parseLong( source );
			
		} catch(IllegalArgumentException iae) {
			
			iae.printStackTrace();
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		
		//User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		Optional<Organization> organization = this.organizationRepository.findById(organizationId);
		
		return organization.orElse(null);
	}

}
