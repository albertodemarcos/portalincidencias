package es.incidence.ms.domain.entities.users.impl;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

import es.incidence.ms.domain.embebbed.PersonalData;
import es.incidence.ms.domain.embebbed.PostalData;
import es.incidence.ms.domain.entities.users.User;

@Entity
@DiscriminatorValue("EMPLOYEE")
public class Employee extends User {

	private static final long serialVersionUID = -2812215365886696015L;

	/**
	 * Employee Identification Number
	 */
	private String ein;
	private String alias;
	private PersonalData personaldata;
	private PostalData postalData;

	@Size(max = 256)
	@Column(name = "type", length = 50, nullable = false)
	public String getEin() {
		return ein;
	}

	public void setEin(String ein) {
		this.ein = ein;
	}

	@Size(max = 256)
	@Column(name = "type", length = 50, nullable = false)
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Embedded
	public PersonalData getPersonaldata() {
		return personaldata;
	}

	public void setPersonaldata(PersonalData personaldata) {
		this.personaldata = personaldata;
	}

	@Embedded
	public PostalData getPostalData() {
		return postalData;
	}

	public void setPostalData(PostalData postalData) {
		this.postalData = postalData;
	}
}
