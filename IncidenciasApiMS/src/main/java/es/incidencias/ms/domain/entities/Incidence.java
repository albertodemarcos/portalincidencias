package es.incidencias.ms.domain.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

import es.incidencias.ms.domain.embebbed.Location;
import es.incidencias.ms.domain.entities.organization.impl.TownHall;
import es.incidencias.ms.domain.entities.users.portal.impl.Citizen;
import es.incidencias.ms.domain.entities.users.portal.impl.Employee;

@Entity
@Table(name = "jhi_incidence")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Incidence {

	private Long id;
	private String title;
	private String description;
	private Date startDate;
	private Date endDate;	
	private Location location;
	private TownHall townHall;
	private Citizen citizen; //this user create incidence
	private Employee employee; //this user finish incidence
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "incidence_sequence")
    @SequenceGenerator(name = "incidence_sequence", sequenceName="sequence_incidence", allocationSize=1)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Size(max = 255)
	@Column(name = "title", length = 255)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Lob
	@Type(type="org.hibernate.type.TextType")
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

	@Embedded
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public TownHall getTownHall() {
		return townHall;
	}

	public void setTownHall(TownHall townHall) {
		this.townHall = townHall;
	}

	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}