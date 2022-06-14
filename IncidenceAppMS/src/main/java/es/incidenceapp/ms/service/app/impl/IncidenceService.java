package es.incidenceapp.ms.service.app.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import es.incidenceapp.ms.components.HttpMicroserviceService;
import es.incidenceapp.ms.components.URLConstans;
import es.incidenceapp.ms.domain.dtos.ActionResponse;
import es.incidenceapp.ms.domain.dtos.IncidenceDTO;
import es.incidenceapp.ms.domain.dtos.IncidenceFilterDTO;
import es.incidenceapp.ms.service.app.IIncidenceService;

@Service
public class IncidenceService implements IIncidenceService {
	
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );
	
	@Autowired
	private HttpMicroserviceService httpMicroserviceService;

	@Override
	public ActionResponse getIncidence(Long incidenceDTOId) {
		// TODO Auto-generated method stub
		logger.info("Method: IncidenceService.getIncidence(incidenceDTOId={})", incidenceDTOId);
		
		if( incidenceDTOId == null || incidenceDTOId <= 0L) 
		{
			logger.error("The incidenceDTOId has defects. incidenceDTOId={}", incidenceDTOId);
			
			return new ActionResponse(URLConstans.NOK, "The incidenceDTOId has not ID" );
		}
		
		ActionResponse _response = this.httpMicroserviceService.getEntity(incidenceDTOId, URLConstans.PORTAL_INCIDENCE, URLConstans.INCIDENCE);
		
		logger.info("End Method: IncidenceService.getIncidence(incidenceDTOId={}). Result: {}", incidenceDTOId, _response.getCode() );
		
		return _response;
	}

	@Override
	public ActionResponse createIncidence(IncidenceDTO incidenceDTO, BindingResult result) {
		// TODO Auto-generated method stub
		logger.info("Method: IncidenceService.createIncidence(incidenceDTO={})", incidenceDTO != null ? incidenceDTO.toString() : null );
		
		if( incidenceDTO == null ) {

			logger.error("The incidenceDTO has defects. Error={}", result.getFieldErrors().toString());
			
			return new ActionResponse(URLConstans.NOK, "The incidenceDTO has defects.", result.getFieldErrors().toString() );
		}
		
		ActionResponse _response = this.httpMicroserviceService.saveEntity(incidenceDTO, URLConstans.PORTAL_INCIDENCE, URLConstans.INCIDENCE);
		
		logger.info("End Method: IncidenceService.createIncidence(incidenceDTO={}). Result: {}", incidenceDTO != null ? incidenceDTO.toString() : null, _response.getCode() );
		
		return _response;
	}

	@Override
	public ActionResponse deleteIncidenceId(Long incidenceDTOId) {
		// TODO Auto-generated method stub
		logger.info("Method: IncidenceService.deleteOrganizationId(incidenceDTOId={})", incidenceDTOId);
		
		if( incidenceDTOId == null || incidenceDTOId <= 0L) 
		{
			logger.error("The incidenceDTOId has defects. incidenceDTOId={}", incidenceDTOId);
			
			return new ActionResponse(URLConstans.NOK, "The incidenceDTOId has not ID" );
		}
		
		ActionResponse _response = this.httpMicroserviceService.deleteEntity(incidenceDTOId, URLConstans.PORTAL_INCIDENCE, URLConstans.INCIDENCE);
		
		logger.info("End Method: IncidenceService.deleteOrganizationId(incidenceDTOId={}). Result: {}", incidenceDTOId, _response.getCode() );
		
		return _response;
	}

	@Override
	public ActionResponse getIncidences(IncidenceFilterDTO incidenceFilterDTO) {
		// TODO Auto-generated method stub
		logger.info("Method: IncidenceService.getIncidences(incidenceFilterDTO={})", incidenceFilterDTO != null ? incidenceFilterDTO.toString() : null );
		
		if( incidenceFilterDTO == null ) {

			logger.error("The incidenceFilterDTO has defects");
			
			return new ActionResponse(URLConstans.NOK, "The incidenceFilterDTO has defects." );
		}
		
		ActionResponse _response = this.httpMicroserviceService.listEntities(incidenceFilterDTO, URLConstans.PORTAL_INCIDENCE, URLConstans.INCIDENCE);
		
		logger.info("End Method: IncidenceService.getIncidences(incidenceFilterDTO={}). Result: {}", incidenceFilterDTO != null ? incidenceFilterDTO.toString() : null, _response.getCode() );
		
		return _response;
	}


}
