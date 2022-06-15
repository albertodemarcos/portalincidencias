package es.incidence.ms.domain.entities.organizations.impl;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import es.incidence.ms.domain.entities.organizations.AbstractOrganization;
import es.incidence.ms.domain.entities.organizations.IOrganization;
import es.incidence.ms.domain.entities.users.impl.Employee;


@Entity
@Table(name = "jhi_organization")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Organization extends AbstractOrganization implements IOrganization {

	private Set<Employee> employees = new HashSet<Employee>();

	@OneToMany(orphanRemoval = true, mappedBy = "organization")
	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
