package es.incidence.ms.web.rest.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.incidence.ms.domain.entities.incidences.Incidence;
import es.incidence.ms.service.impl.IncidenceService;
import es.incidence.ms.utils.ActionResponse;
import es.incidence.ms.utils.dtos.IncidenceDto;
import es.incidence.ms.utils.filters.impl.IncidenceFilter;
import es.incidence.ms.validators.IncidenceValidator;


@RestController
@RequestMapping(path = {"/incidenceApi"})
public class IncidenceController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IncidenceValidator incidenceValidator;
	
	@Autowired
	private IncidenceService incidenceService;

	@GetMapping(path = {"/incidence/{incidence}"})
	public ActionResponse getIncidence(@PathVariable Incidence incidence) 
	{
		logger.info("Method: IncidencesController.getIncidence(incidenceId={})", incidence != null ? incidence.getId() : null );
		ActionResponse response = this.incidenceService.getIncidence(incidence);
		return response;
	}
	
	@PostMapping(path = {"/createIncidence"})
	public ActionResponse createIncidence(@RequestBody(required = true) IncidenceDto incidenceDto, BindingResult result) 
	{
		logger.info("Method: IncidencesController.createIncidence(incidenceDto={})", (incidenceDto!=null?incidenceDto.toString():null) );
		
		incidenceValidator.validate(incidenceDto, result);
		
		if( result.hasErrors() ) {
			
			return new ActionResponse("-1", null, result.getAllErrors() );
		}
		
		ActionResponse response = this.incidenceService.createIncidence(incidenceDto, result);

		return response;
	}
		
	@DeleteMapping(path = {"/incidence/{incidenceId}"})
	public ActionResponse deleteIncidence(@PathVariable Long incidenceId) 
	{
		logger.info("Method: IncidencesController.deleteIncidenceById(incidenceId={})", incidenceId );
		ActionResponse response = this.incidenceService.deleteIncidence(incidenceId);
		return response;
	}
	
	@GetMapping(path = {"/incidences"})
	public ActionResponse getIncidences(@RequestBody(required = true) final IncidenceFilter incidenceFilter, @ModelAttribute Pageable page)
	{
		logger.info("Method: IncidencesController.getIncidences(incidenceFilter={})", (incidenceFilter !=null ? incidenceFilter.toString() : null ) );
		ActionResponse response = this.incidenceService.getIncidences(null, null, incidenceFilter, page);
		return response;
	}
}

