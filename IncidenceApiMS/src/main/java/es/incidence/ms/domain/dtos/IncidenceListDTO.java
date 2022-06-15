package es.incidence.ms.domain.dtos;

import java.util.Date;

public class IncidenceListDTO {

	private Long id;
	private String title;
	private String description;
	private Date startDate;
	private Date endDate;
	private Long longitude;
	private Long latitude;
	private Long organizationId;
	private Long citizenId;
	private Long employeeId;
	
	public IncidenceListDTO() {
		super();
	}
	
	//IncidenceRepositoryImpl.getIncidencesByFilter
	public IncidenceListDTO(Long id, String title, String description, Date startDate, Date endDate, Long longitude, Long latitude, Long organizationId, Long citizenId, Long employeeId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.longitude = longitude;
		this.latitude = latitude;
		this.organizationId = organizationId;
		this.citizenId = citizenId;
		this.employeeId = employeeId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getLongitude() {
		return longitude;
	}

	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}

	public Long getLatitude() {
		return latitude;
	}

	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Long getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(Long citizenId) {
		this.citizenId = citizenId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

}
