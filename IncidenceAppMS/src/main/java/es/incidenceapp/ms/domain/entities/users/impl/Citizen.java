package es.incidenceapp.ms.domain.entities.users.impl;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

import es.incidenceapp.ms.domain.entities.users.User;


@Entity
@DiscriminatorValue("CITIZEN")
public class Citizen extends User {

	private static final long serialVersionUID = -1444839614842519907L;
	
	/**
	 * Citizen Identification
	 */
	private String citizenIdentification;

	
	@Size(max = 256)
	@Column(name = "citizen_identification", length = 50, nullable = false)
	public String getCitizenIdentification() {
		return citizenIdentification;
	}

	public void setCitizenIdentification(String citizenIdentification) {
		this.citizenIdentification = citizenIdentification;
	}
	
	
	
	

}
