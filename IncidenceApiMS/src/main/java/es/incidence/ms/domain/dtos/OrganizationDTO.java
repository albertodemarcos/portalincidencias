package es.incidence.ms.domain.dtos;

import java.io.Serializable;

import es.incidence.ms.domain.enums.OrganizationType;


public class OrganizationDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4578913419346250386L;
	
	private Long id;
	private String name;
	private String description;
	private OrganizationType type;
	private Long longitude;
	private Long latitude;

	public OrganizationDTO() {
		super();
	}

	public OrganizationDTO(Long id, String name, String description, OrganizationType type) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.type = type;
	}
	
	public boolean isNew() {
		return id == null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public OrganizationType getType() {
		return type;
	}

	public void setType(OrganizationType type) {
		this.type = type;
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
	
	

}
