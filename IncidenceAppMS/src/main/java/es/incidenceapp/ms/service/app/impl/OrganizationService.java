package es.incidenceapp.ms.service.app.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import es.incidenceapp.ms.components.HttpMicroserviceService;
import es.incidenceapp.ms.components.URLConstans;
import es.incidenceapp.ms.domain.dtos.ActionResponse;
import es.incidenceapp.ms.domain.dtos.OrganizationDTO;
import es.incidenceapp.ms.domain.dtos.OrganizationFilterDTO;
import es.incidenceapp.ms.service.app.IOrganizationService;

@Service
public class OrganizationService implements IOrganizationService {

	
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );
	
	@Autowired
	private HttpMicroserviceService httpMicroserviceService;

	@Override
	public ActionResponse getOrganization(Long organizationDTOId) {
		// TODO Auto-generated method stub
		logger.info("Method: OrganizationService.getOrganization(organizationDTOId={})", organizationDTOId);
		
		if( organizationDTOId == null || organizationDTOId <= 0L) 
		{
			logger.error("The organizationDTOId has defects. organizationDTOId={}", organizationDTOId);
			
			return new ActionResponse(URLConstans.NOK, "The organizationDTOId has not ID" );
		}
		
		ActionResponse _response = this.httpMicroserviceService.getEntity(organizationDTOId, URLConstans.PORTAL_INCIDENCE, URLConstans.ORGANIZATION);
		
		logger.info("End Method: OrganizationService.getOrganization(organizationDTOId={}). Result: {}", organizationDTOId, _response.getCode() );
		
		return _response;
	}

	@Override
	public ActionResponse createOrganization(OrganizationDTO organizationDTO, BindingResult result) {
		// TODO Auto-generated method stub
		logger.info("Method: OrganizationService.createOrganization(organizationDTO={})", organizationDTO != null ? organizationDTO.toString() : null );
		
		if( organizationDTO == null ) {

			logger.error("The organizationDTO has defects. Error={}", result.getFieldErrors().toString());
			
			return new ActionResponse(URLConstans.NOK, "The organizationDTO has defects.", result.getFieldErrors().toString() );
		}
		
		ActionResponse _response = this.httpMicroserviceService.saveEntity(organizationDTO, URLConstans.PORTAL_INCIDENCE, URLConstans.ORGANIZATION);
		
		logger.info("End Method: OrganizationService.createOrganization(organizationDTO={}). Result: {}", organizationDTO != null ? organizationDTO.toString() : null, _response.getCode() );
		
		return _response;
	}

	@Override
	public ActionResponse deleteOrganizationId(Long organizationDTOId) {
		// TODO Auto-generated method stub
		logger.info("Method: OrganizationService.deleteOrganizationId(organizationDTOId={})", organizationDTOId);
		
		if( organizationDTOId == null || organizationDTOId <= 0L) 
		{
			logger.error("The organizationDTOId has defects. organizationDTOId={}", organizationDTOId);
			
			return new ActionResponse(URLConstans.NOK, "The organizationDTOId has not ID" );
		}
		
		ActionResponse _response = this.httpMicroserviceService.deleteEntity(organizationDTOId, URLConstans.PORTAL_INCIDENCE, URLConstans.ORGANIZATION);
		
		logger.info("End Method: OrganizationService.deleteOrganizationId(organizationDTOId={}). Result: {}", organizationDTOId, _response.getCode() );
		
		return _response;
	}

	@Override
	public ActionResponse getOrganizations(OrganizationFilterDTO organizationFilterDTO) {
		// TODO Auto-generated method stub
		logger.info("Method: OrganizationService.createOrganization(organizationFilterDTO={})", organizationFilterDTO != null ? organizationFilterDTO.toString() : null );
		
		if( organizationFilterDTO == null ) {

			logger.error("The organizationFilterDTO has defects");
			
			return new ActionResponse(URLConstans.NOK, "The organizationFilterDTO has defects." );
		}
		
		ActionResponse _response = this.httpMicroserviceService.listEntities(organizationFilterDTO, URLConstans.PORTAL_INCIDENCE, URLConstans.ORGANIZATION);
		
		logger.info("End Method: OrganizationService.createOrganization(organizationFilterDTO={}). Result: {}", organizationFilterDTO != null ? organizationFilterDTO.toString() : null, _response.getCode() );
		
		return _response;
	}
	
}
