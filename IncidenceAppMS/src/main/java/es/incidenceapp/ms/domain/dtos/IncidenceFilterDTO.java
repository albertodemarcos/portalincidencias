package es.incidenceapp.ms.domain.dtos;

import java.io.Serializable;
import java.util.Date;

public class IncidenceFilterDTO implements Serializable, IFilter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7323334250359406967L;
	
	private String title;
	private String description;
	private Date startDate;
	private Date endDate;
	private Boolean resolved;
	private Long organizationId;
	private Long citizenId;
	private Long employeeId;

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

	public Boolean getResolved() {
		return resolved;
	}

	public void setResolved(Boolean resolved) {
		this.resolved = resolved;
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
