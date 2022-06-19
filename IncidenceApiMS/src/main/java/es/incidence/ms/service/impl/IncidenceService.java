package es.incidence.ms.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import es.incidence.ms.domain.dtos.IncidenceDTO;
import es.incidence.ms.domain.dtos.IncidenceFilterDTO;
import es.incidence.ms.domain.dtos.IncidenceListDTO;
import es.incidence.ms.domain.embebbed.Location;
import es.incidence.ms.domain.entities.incidences.Incidence;
import es.incidence.ms.domain.entities.organizations.impl.Organization;
import es.incidence.ms.domain.entities.users.impl.Citizen;
import es.incidence.ms.domain.entities.users.impl.Employee;
import es.incidence.ms.repository.CitizenRepository;
import es.incidence.ms.repository.EmployeeRepository;
import es.incidence.ms.repository.IncidenceRepository;
import es.incidence.ms.repository.OrganizationRepository;
import es.incidence.ms.service.IIncidenceService;
import es.incidence.ms.utils.ActionResponse;


@Service
public class IncidenceService implements IIncidenceService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IncidenceRepository incidenceRepository;
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Autowired
	private CitizenRepository citizenRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public ActionResponse getIncidence(Incidence incidence) {
		// TODO Auto-generated method stub
		logger.info("Method: IncidenceService.getIncidence(incidenceId={})", incidence != null ? incidence.getId() : null);
		
		if( incidence == null) {
			
			logger.error("Method: IncidenceService.getIncidence(incidenceId={}) has errors", incidence != null ? incidence.getId() : null);
			
			return new ActionResponse("1", "", null);
		}
		
		IncidenceDTO incidenceDTO = this.populateIncidenceDTO(incidence);
		
		return new ActionResponse("1", "", incidenceDTO);
	}

	@Override
	public ActionResponse createIncidence(IncidenceDTO incidenceDTO, BindingResult result) {
		// TODO Auto-generated method stub
		logger.info("Method: IncidenceService.createIncidence(incidenceDTO={})", (incidenceDTO!=null?incidenceDTO.toString():null) );
		
		Incidence incidence = null;
		
		if( incidenceDTO.isNew() ) {
			
			incidence = new Incidence();
			
		} else {
			
			incidence = incidenceRepository.findByIdAndOrganizationId(incidenceDTO.getId(), incidenceDTO.getOrganizationId() ).orElse(null);
			
			if( incidence == null ) 
				new ActionResponse("1", "La entidad no existe");
						
		}
		
		incidence.setTitle(incidenceDTO.getTitle());
		incidence.setDescription(incidenceDTO.getDescription());
		incidence.setStartDate(incidenceDTO.getStartDate());

		Location location = new Location(incidenceDTO.getLongitude(), incidenceDTO.getLatitude() );
		incidence.setLocation(location);
		
		Organization organization = this.organizationRepository.findById(incidenceDTO.getOrganizationId()).orElse(null);
		incidence.setOrganization(organization);
		
		Citizen citizen = this.citizenRepository.findByIdAndOrganizationId(incidenceDTO.getCitizenId(), incidenceDTO.getOrganizationId()).orElse(null);
		incidence.setCitizen(citizen);
		
		Employee employee = this.employeeRepository.findByIdAndOrganizationId(incidenceDTO.getEmployeeId(), incidenceDTO.getOrganizationId()).orElse(null);
		incidence.setEmployee(employee);
		
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
	public ActionResponse getIncidences(final Long citizenId, final Long organizationId, final IncidenceFilterDTO incidenceFilterDTO, Pageable page) {
		// TODO Auto-generated method stub
		logger.info("Method: IncidenceService.getIncidences(incidenceFilter={})", (incidenceFilterDTO !=null ? incidenceFilterDTO.toString() : null ) );
		
		ActionResponse actionResponse = null;
		
		try {
		
			Page<IncidenceListDTO> incidencesPage = incidenceRepository.getIncidencesByFilter(citizenId, organizationId, incidenceFilterDTO, page);
			
			if( incidencesPage == null ) {
				
				throw new Exception("No hay datos");
			}
			
			actionResponse = new ActionResponse("1", null, incidencesPage);
			
		} catch(Exception e) {
			
			logger.error("Se ha producido un error");
			
			e.printStackTrace();
			
			actionResponse = new ActionResponse("-1", null, null);
		}
		
		return actionResponse;
	}
	
	@Override
	public ActionResponse getResolveIncident(Incidence incidence, final Employee employee, final Date endDate) {
		// TODO Auto-generated method stub
		
		if( employee == null || ( endDate == null || endDate.before( new Date() ) ) ) 
		{			
			Long employeeId = employee != null ? employee.getId(): null;
			logger.error("Se ha producido un error al intentar resolver la incidencia con id={} porque los argumentos no son validos. Empleado={}, Fecha resolucion={}", incidence.getId(), employeeId, endDate);
			return new ActionResponse("-1", endDate);
		}
		
		ActionResponse response = null;
		
		try {
			
			incidence.setEmployee(employee);
			incidence.setEndDate(endDate);

			this.incidenceRepository.save(incidence);
			
			response = new ActionResponse("1", "", incidence);
			
		}catch(Exception e){
			
			logger.error("Se ha producido un error al intentar persistir la resolucion de la incidencia");
			
			e.printStackTrace();
			
			response = new ActionResponse("-1", "", incidence);
		}
		
		return response;
	}

	@Override
	public ActionResponse getIncidencesCitizen(final Long citizenId, final Long organizationId) {
		// TODO Auto-generated method stub
		
		if( citizenId == null || organizationId == null ) {
			
			logger.error("Error! No se puede obtener las incidencias porque no existe los argumentos: citizenId={}, organizationId={}", citizenId, organizationId);
			
			return null;
		}
		
		ActionResponse response = null;
		
		try {
			
			List<Incidence> incidences = this.incidenceRepository.findAllByCitizenIdAndOrganizationIdAndResolvedIsNotTrue(citizenId, organizationId);
			
			response = new ActionResponse("1", "", incidences);
			
		}catch(Exception e) {
			
			logger.error("Se ha producido un error al intentar encontrar las incidencias para citizenId={}, organizationId={}", citizenId, organizationId);
			
			e.printStackTrace();
			
			response = new ActionResponse("-1", "", null);
		}
		
		return response;
	}
	
	private IncidenceDTO populateIncidenceDTO(Incidence incidence) {
		
		IncidenceDTO incidenceDTO = new IncidenceDTO();
		
		incidenceDTO.setId(incidence.getId());
		incidenceDTO.setTitle(incidence.getTitle());
		incidenceDTO.setDescription(incidence.getDescription());
		incidenceDTO.setStartDate(incidence.getStartDate());
		incidenceDTO.setEndDate(incidence.getEndDate());
		
		if( incidence.getCitizen() != null )
		
			incidenceDTO.setCitizenId(incidence.getCitizen().getId());
		
		if( incidence.getEmployee() != null )
		
			incidenceDTO.setEmployeeId(incidence.getEmployee().getId());
		
		if( incidence.getOrganization() != null )
		
			incidenceDTO.setOrganizationId(incidence.getOrganization().getId());

		this.populateLocationToIncidenceDTO(incidence, incidenceDTO);
		
		return incidenceDTO;
	}

	private void populateLocationToIncidenceDTO(Incidence incidence, IncidenceDTO incidenceDTO) {
		
		if( incidence.getLocation() == null ) {
			return;
		}		
		
		incidenceDTO.setLatitude(  incidence.getLocation().getLongitude() );
		incidenceDTO.setLongitude( incidence.getLocation().getLatitude() );		
	}


	
	

}
