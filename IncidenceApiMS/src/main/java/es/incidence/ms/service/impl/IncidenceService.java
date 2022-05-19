package es.incidence.ms.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import es.incidence.ms.domain.embebbed.Location;
import es.incidence.ms.domain.entities.incidences.Incidence;
import es.incidence.ms.repository.IncidenceRepository;
import es.incidence.ms.service.IIncidenceService;
import es.incidence.ms.utils.ActionResponse;
import es.incidence.ms.utils.dtos.IncidenceDto;
import es.incidence.ms.utils.filters.impl.IncidenceFilter;


@Service
public class IncidenceService implements IIncidenceService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IncidenceRepository incidenceRepository;
	

	@Override
	public ActionResponse getIncidence(Long incidenceId) {
		// TODO Auto-generated method stub
		logger.info("Method: IncidenceService.getIncidence(incidenceId={})", incidenceId);
		
		return null;
	}

	@Override
	public ActionResponse createIncidence(IncidenceDto incidenceDto, BindingResult result) {
		// TODO Auto-generated method stub
		logger.info("Method: IncidenceService.createIncidence(incidenceDto={})", (incidenceDto!=null?incidenceDto.toString():null) );
		
		Incidence incidence = null;
		
		if( incidenceDto.isNew() ) {
			
			incidence = new Incidence();
			
			
		} else {
			
			incidence = incidenceRepository.findByIdAndOrganizationId(null, incidenceDto.getId()).orElse(null);
			
			if( incidence == null ) {
				new ActionResponse("1", "La entidad no existe");
			}			
		}
		
		incidence.setTitle(null);
		incidence.setDescription(null);
		
		if( incidence.getStartDate() == null ) {
			incidence.setStartDate(null);
		}

		Location location = new Location(incidenceDto.getLongitude(), incidenceDto.getLatitude() );
		incidence.setLocation(location);
		
		
		incidence.setOrganization(null);
		incidence.setCitizen(null);
		incidence.setEmployee(null);
		
		incidenceRepository.save(incidence);
				
		return new ActionResponse("1", "The incidence was created", incidence );
	}

	@Override
	public ActionResponse deleteIncidence(Long incidenceId) {
		// TODO Auto-generated method stub
		logger.info("Method: IncidenceService.deleteIncidence(incidenceId={})", incidenceId );
		
		ActionResponse response = null;
		
		if( incidenceId == null ) {
			
			return new ActionResponse("1", "Error! incidenceId es nulo");
		}
		
		try
		{
			incidenceRepository.deleteById(incidenceId);
			
			response = new ActionResponse("1", null);
		}
		catch(IllegalArgumentException iae) {
			
			logger.error("Se ha producido un error al eliminar la entidad con id={} porque el argumento no es valido", incidenceId);
			logger.error("Error: {}", iae.getMessage());
			
			response = new ActionResponse("1", "El argumento id es invalido");
		}
		catch(Exception e) {
			
			logger.error("Se ha producido un error al eliminar la entidad con id={}", incidenceId);
			logger.error("Error: {}", e.getMessage());
			
			response = new ActionResponse("1", "Se ha producido un error");
		}
		
		return response;
	}

	@Override
	public ActionResponse getIncidences(IncidenceFilter incidenceFilter) {
		// TODO Auto-generated method stub
		logger.info("Method: IncidenceService.getIncidences(incidenceFilter={})", (incidenceFilter !=null ? incidenceFilter.toString() : null ) );
		
		return null;
	}

}
