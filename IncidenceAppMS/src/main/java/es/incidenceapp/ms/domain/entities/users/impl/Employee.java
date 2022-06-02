package es.incidenceapp.ms.domain.entities.users.impl;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.incidenceapp.ms.domain.entities.organizations.impl.Organization;
import es.incidenceapp.ms.domain.entities.users.User;


@Entity
@DiscriminatorValue("EMPLOYEE")
public class Employee extends User {

	private static final long serialVersionUID = -2812215365886696015L;

	/**
	 * Employee Identification Number
	 */
	private String ein;
	private String alias;
    private Organization organization;

	@Size(max = 256)
	@Column(name = "ein", length = 50, nullable = false)
	public String getEin() {
		return ein;
	}

	public void setEin(String ein) {
		this.ein = ein;
	}

	@Size(max = 256)
	@Column(name = "alias", length = 50, nullable = false)
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
}
