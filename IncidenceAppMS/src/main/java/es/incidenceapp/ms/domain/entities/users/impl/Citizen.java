package es.incidenceapp.ms.domain.entities.users.impl;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import es.incidenceapp.ms.domain.entities.users.User;


@Entity
@DiscriminatorValue("CITIZEN")
public class Citizen extends User {

	private static final long serialVersionUID = -1444839614842519907L;
	
	/**
	 * Citizen Identification
	 */
	

}
