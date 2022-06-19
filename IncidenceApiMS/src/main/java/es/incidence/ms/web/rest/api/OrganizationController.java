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

import es.incidence.ms.domain.dtos.OrganizationDTO;
import es.incidence.ms.domain.dtos.OrganizationFilterDTO;
import es.incidence.ms.domain.entities.organizations.impl.Organization;
import es.incidence.ms.service.impl.OrganizationService;
import es.incidence.ms.utils.ActionResponse;
import es.incidence.ms.validators.OrganizationValidator;


@RestController
@RequestMapping(path = {"/organizationApi"})
public class OrganizationController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private OrganizationValidator organizationValidator;
	
	@Autowired
	private OrganizationService organizationService;

	@GetMapping(path = {"/organization/{organization}"})
	public ActionResponse getOrganization(@PathVariable Organization organization) 
	{
		logger.info("Method: OrganizationsController.getOrganization(organizationId={})", organization != null ? organization.getId() : null );
		ActionResponse response = this.organizationService.getOrganization(organization);
		return response;
	}
	
	@PostMapping(path = {"/createOrganization"})
	public ActionResponse createOrganization(@RequestBody(required = true) OrganizationDTO organizationDTO, BindingResult result) 
	{
		logger.info("Method: OrganizationsController.createOrganization(organizationDTO={})", (organizationDTO!=null ? organizationDTO.toString():null) );
		
		organizationValidator.validate(organizationDTO, result);
		
		if( result.hasErrors() ) {
			
			return new ActionResponse("-1", null, result.getAllErrors() );
		}
		
		ActionResponse response = this.organizationService.createOrganization(organizationDTO, result);

		return response;
	}
		
	@DeleteMapping(path = {"/organization/{organization}"})
	public ActionResponse deleteOrganization(@PathVariable Long organizationId) 
	{
		logger.info("Method: OrganizationsController.deleteOrganizationById(organizationId={})", organizationId );
		ActionResponse response = this.organizationService.deleteOrganization(organizationId);
		return response;
	}
	
	@GetMapping(path = {"/organizations"})
	public ActionResponse getOrganizations(@RequestBody(required = true) final OrganizationFilterDTO organizationFilterDTO, @ModelAttribute Pageable page)
	{
		logger.info("Method: OrganizationsController.getOrganizations(organizationFilter={})", (organizationFilterDTO !=null ? organizationFilterDTO.toString() : null ) );
		ActionResponse response = this.organizationService.getOrganizations(null, null, organizationFilterDTO, page);
		return response;
	}
}
