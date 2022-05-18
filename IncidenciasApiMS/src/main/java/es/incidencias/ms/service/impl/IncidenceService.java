package es.incidencias.ms.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import es.incidencias.ms.domain.embebbed.Location;
import es.incidencias.ms.domain.entities.Incidence;
import es.incidencias.ms.repository.IncidenceRepository;
import es.incidencias.ms.service.IIncidenceService;
import es.incidencias.ms.utils.ActionResponse;
import es.incidencias.ms.utils.dtos.IncidenceDto;
import es.incidencias.ms.utils.filters.impl.IncidenceFilter;


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
		
		Incidence incidence = new Incidence();
		
		incidence.setId(null);
		incidence.setTitle(null);
		incidence.setDescription(null);
		
		if( incidence.getStartDate() == null ) {
			incidence.setStartDate(null);
		}

		Location location = new Location(incidenceDto.getLongitude(), incidenceDto.getLatitude() );
		incidence.setLocation(location);
		
		
		incidence.setTownHall(null);
		incidence.setCitizen(null);
		incidence.setEmployee(null);
		
		incidenceRepository.save(incidence);
				
		return new ActionResponse("1", "The incidence was created", incidence );
	}

	@Override
	public ActionResponse deleteIncidence(Long incidenceId) {
		// TODO Auto-generated method stub
		logger.info("Method: IncidenceService.deleteIncidence(incidenceId={})", incidenceId );
		
		return null;
	}

	@Override
	public ActionResponse getIncidences(IncidenceFilter incidenceFilter) {
		// TODO Auto-generated method stub
		logger.info("Method: IncidenceService.getIncidences(incidenceFilter={})", (incidenceFilter !=null ? incidenceFilter.toString() : null ) );
		
		return null;
	}

}
