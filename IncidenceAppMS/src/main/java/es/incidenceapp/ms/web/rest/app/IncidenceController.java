package es.incidenceapp.ms.web.rest.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import es.incidenceapp.ms.domain.dtos.ActionResponse;
import es.incidenceapp.ms.domain.dtos.IncidenceDTO;
import es.incidenceapp.ms.domain.dtos.IncidenceFilterDTO;


@RestController
@RequestMapping(path = {"/incidencesAppApi"})
public class IncidenceController {

	private final Logger logger = LoggerFactory.getLogger( this.getClass() );
	
	
	@GetMapping(path = {"/incidence/{incidenceId}"})
	public ActionResponse getIncidence(@PathVariable Long incidenceId) {
		
		logger.info("Method: IncidenceController.getIncidence(incidenceId={})", incidenceId != null ? incidenceId : null );
		ActionResponse response = null;//this.incidenceService.getIncidence(incidence);
		return response;
	}
	
	@GetMapping(path = {"/incidence/{incidenceId}"})
	public ActionResponse getEditIncidence(@PathVariable Long incidenceId) {
		
		logger.info("Method: IncidenceController.getEditIncidence(incidenceId={})", incidenceId != null ? incidenceId : null );
		ActionResponse response = null;//this.incidenceService.getIncidence(incidence);
		return response;
	}

	@PostMapping(path = {"/createIncidence"})
	public ActionResponse postCreateIncidence(@RequestBody(required = true) IncidenceDTO incidenceDto, BindingResult result) {
		
		logger.info("Method: IncidenceController.postCreateIncidence(incidenceDto={})", (incidenceDto!=null?incidenceDto.toString():null) );
		
		ActionResponse response = null;//this.incidenceService.createIncidence(incidenceDto, result);

		return response;
	}
	
	@DeleteMapping(path = {"/incidence/{incidenceId}"})
	public ActionResponse getDeleteIncidence(@PathVariable Long incidenceId) {
		
		logger.info("Method: IncidenceController.deleteIncidenceById(incidenceId={})", incidenceId );
		ActionResponse response = null;//this.incidenceService.deleteIncidence(incidenceId);
		return response;
	}
	
	@GetMapping(path = {"/incidences"})
	public ActionResponse getListIncidences(@RequestBody(required = true) final IncidenceFilterDTO incidenceFilterDTO, @ModelAttribute Pageable page) {
		
		logger.info("Method: IncidenceController.getListIncidences(incidenceFilterDTO={})", (incidenceFilterDTO !=null ? incidenceFilterDTO.toString() : null ) );
		ActionResponse response = null;//this.incidenceService.getIncidences(null, null, incidenceFilter, page);
		return response;
	}
	
}
