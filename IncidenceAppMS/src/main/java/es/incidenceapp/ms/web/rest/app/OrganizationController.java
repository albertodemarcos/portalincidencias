package es.incidenceapp.ms.web.rest.app;

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

import es.incidenceapp.ms.domain.dtos.ActionResponse;
import es.incidenceapp.ms.domain.dtos.OrganizationDTO;
import es.incidenceapp.ms.domain.dtos.OrganizationFilterDTO;
import es.incidenceapp.ms.service.app.impl.OrganizationService;

@RestController
@RequestMapping(path = {"/organizationsAppApi"})
public class OrganizationController {

	private final Logger logger = LoggerFactory.getLogger( this.getClass() );
	
	@Autowired
	private OrganizationService organizationService;
	
	@GetMapping(path = {"/organization/{organizationId}"})
	public ActionResponse getOrganization(@PathVariable Long organizationId) {
		
		logger.info("Method: OrganizationController.getOrganization(organizationId={})", organizationId != null ? organizationId : null );
		ActionResponse response = this.organizationService.getOrganization(organizationId);
		return response;
	}
	
	@GetMapping(path = {"/organization/{organizationId}"})
	public ActionResponse getEditOrganization(@PathVariable Long organizationId) {
		
		logger.info("Method: OrganizationController.getEditOrganization(organizationId={})", organizationId != null ? organizationId : null );
		ActionResponse response = this.organizationService.getOrganization(organizationId);
		return response;
	}

	@PostMapping(path = {"/createOrganization"})
	public ActionResponse postCreateOrganization(@RequestBody(required = true) OrganizationDTO organizationDto, BindingResult result) {
		
		logger.info("Method: OrganizationController.postCreateOrganization(organizationDto={})", (organizationDto != null ? organizationDto.toString():null) );
		
		ActionResponse response = this.organizationService.createOrganization(organizationDto,result);

		return response;
	}
	
	@DeleteMapping(path = {"/organization/{organizationId}"})
	public ActionResponse getDeleteOrganization(@PathVariable Long organizationId) {
		
		logger.info("Method: OrganizationController.getDeleteOrganization(organizationId={})", organizationId != null ? organizationId : null );
		ActionResponse response = this.organizationService.deleteOrganizationId(organizationId);
		return response;
	}
	
	@GetMapping(path = {"/organizations"})
	public ActionResponse getListOrganizations(@RequestBody(required = true) final OrganizationFilterDTO organizationFilterDTO, @ModelAttribute Pageable page) {
		
		logger.info("Method: OrganizationController.getListOrganizations(organizationFilterDTO={})", (organizationFilterDTO !=null ? organizationFilterDTO.toString() : null ) );
		ActionResponse response = this.organizationService.getOrganizations(organizationFilterDTO);
		return response;
	}
	
	
}
