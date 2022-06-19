package es.incidence.ms.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import es.incidence.ms.domain.dtos.OrganizationDTO;
import es.incidence.ms.domain.dtos.OrganizationFilterDTO;
import es.incidence.ms.domain.dtos.OrganizationListDTO;
import es.incidence.ms.domain.embebbed.Location;
import es.incidence.ms.domain.entities.organizations.impl.Organization;
import es.incidence.ms.repository.OrganizationRepository;
import es.incidence.ms.service.IOrganizationService;
import es.incidence.ms.utils.ActionResponse;

@Service
public class OrganizationService implements IOrganizationService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private OrganizationRepository organizationRepository;

	@Override
	public ActionResponse getOrganization(Organization organization) {
		// TODO Auto-generated method stub
		logger.info("Method: OrganizationService.getOrganization(organizationId={})", organization != null ? organization.getId() : null);
		
		if( organization == null) {
			
			logger.error("Method: OrganizationService.getOrganization(organizationId={}) has errors", organization != null ? organization.getId() : null);
			
			return new ActionResponse("1", "", null);
		}
		
		OrganizationDTO organizationDto = this.populateOrganizationDTO(organization);
		
		return new ActionResponse("1", "", organizationDto);
	}

	@Override
	public ActionResponse createOrganization(OrganizationDTO organizationDTO, BindingResult result) {
		// TODO Auto-generated method stub
		logger.info("Method: OrganizationService.createOrganization(organizationDto={})", (organizationDTO!=null?organizationDTO.toString():null) );
		
		Organization organization = null;
		
		if( organizationDTO.isNew() ) {
			
			organization = new Organization();
			
		} else {
			
			organization = organizationRepository.findById(organizationDTO.getId() ).orElse(null);
			
			if( organization == null ) {
				
				return new ActionResponse("-1", "The organization don't exist");
			}
		}
		
		organization.setName(organizationDTO.getName());
		organization.setDescription(organizationDTO.getDescription());
		organization.setType(organizationDTO.getType());

		Location location = new Location(organizationDTO.getLongitude(), organizationDTO.getLatitude() );
		organization.setLocation(location);
		
		organizationRepository.save(organization);
		
		ActionResponse response = new ActionResponse("1", "The organization was created", organization );
				
		return response;
	}

	@Override
	public ActionResponse deleteOrganization(Long organizationId) {
		// TODO Auto-generated method stub
		logger.info("Method: OrganizationService.deleteOrganization(organizationId={})", organizationId );
		
		ActionResponse response = null;
		
		if( organizationId == null ) {
			
			return new ActionResponse("-1", "Error! organizationId is null");
		}
		
		try
		{
			organizationRepository.deleteById(organizationId);
			
			response = new ActionResponse("1", "The organization was deleted");
		}
		catch(IllegalArgumentException iae) {
			
			logger.error("An error occurred while deleting the entity with id={} because the argument is not valid", organizationId);
			logger.error("Error: {}", iae.getMessage());
			
			response = new ActionResponse("-1", "The id argument is invalid");
		}
		catch(Exception e) {
			
			logger.error("An error occurred while deleting entity with id={}", organizationId);
			logger.error("Error: {}", e.getMessage());
			
			response = new ActionResponse("-1", "Error! The entity was not deleted");
		}
		
		return response;
	}

	@Override
	public ActionResponse getOrganizations(Long citizenId, Long organizationId, OrganizationFilterDTO organizationFilterDTO, Pageable page) {
		// TODO Auto-generated method stub
		logger.info("Method: OrganizationService.getOrganizations(organizationFilter={})", (organizationFilterDTO !=null ? organizationFilterDTO.toString() : null ) );
		
		Page<OrganizationListDTO> organizationsPage = null;
		
		try {
		
			organizationsPage = organizationRepository.getOrganizationsByFilter(organizationFilterDTO, page);
			
			if( organizationsPage == null ) {
				
				throw new Exception("There's not data");
			}
			
		} catch(Exception e) {
			
			logger.error("An error has occurred while obtaining the list of organizations");
			
			logger.error("Error! {}", e.getMessage());
			
			return new ActionResponse("-1", "An error has occurred while obtaining the list of organizations");
		}
		
		ActionResponse actionResponse = new ActionResponse("1", null, organizationsPage);;
		
		return actionResponse;
	}
	
	
	private OrganizationDTO populateOrganizationDTO(Organization organization) {
		
		logger.trace("populateOrganizationDTO(organizationId={})", organization.getId());
		
		OrganizationDTO organizationDTO = new OrganizationDTO();
		
		organizationDTO.setId(organization.getId());
		organizationDTO.setName(organization.getName());
		organizationDTO.setDescription(organization.getDescription());
		organizationDTO.setType(organization.getType());
		
		this.populateLocationToOrganizationDTO(organization, organizationDTO);
		
		return organizationDTO;
	}

	private void populateLocationToOrganizationDTO(Organization organization, OrganizationDTO organizationDTO) {
		
		logger.trace("populateLocationToOrganizationDTO(organizationId={})", organization.getId());
		
		if( organization.getLocation() == null ) {
			return;
		}		
		
		organizationDTO.setLatitude(  organization.getLocation().getLongitude() );
		organizationDTO.setLongitude( organization.getLocation().getLatitude() );		
	}

}
