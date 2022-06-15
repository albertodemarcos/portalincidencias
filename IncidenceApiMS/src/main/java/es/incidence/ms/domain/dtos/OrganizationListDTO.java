package es.incidence.ms.domain.dtos;

import java.io.Serializable;

import es.incidence.ms.domain.enums.OrganizationType;

public class OrganizationListDTO implements Serializable {

	private static final long serialVersionUID = 6923440904315763087L;
	
	private String name;
	private OrganizationType type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OrganizationType getType() {
		return type;
	}

	public void setType(OrganizationType type) {
		this.type = type;
	}

}
