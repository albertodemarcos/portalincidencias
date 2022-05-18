package es.incidencias.ms.web.rest.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.incidencias.ms.service.impl.IncidenceService;
import es.incidencias.ms.utils.ActionResponse;
import es.incidencias.ms.utils.dtos.IncidenceDto;
import es.incidencias.ms.utils.filters.impl.IncidenceFilter;
import es.incidencias.ms.validators.IncidenceValidator;


@RestController
@RequestMapping(path = {"/IncidenceApi"})
public class IncidenceController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IncidenceValidator incidenceValidator;
	
	@Autowired
	private IncidenceService incidenceService;

	@GetMapping(path = {"/incidence/{incidenceId}"})
	public ActionResponse getIncidence(@PathVariable Long incidenceId) 
	{
		logger.info("Method: IncidencesController.getIncidence(incidenceId={})", incidenceId);
		ActionResponse response = this.incidenceService.getIncidence(incidenceId);
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
	
	@PostMapping(path = {"/incidences"})
	public ActionResponse getIncidences(@RequestBody(required = true) final IncidenceFilter incidenceFilter )
	{
		logger.info("Method: IncidencesController.getIncidences(incidenceFilter={})", (incidenceFilter !=null ? incidenceFilter.toString() : null ) );
		ActionResponse response = this.incidenceService.getIncidences(incidenceFilter);
		return response;
	}
	
}
