package es.incidenceapp.ms.domain.embebbed;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;

import es.incidenceapp.ms.domain.enums.Sex;

@Embeddable
public class PersonalData {

	private String name;
	private String surname;
	private String nif;
	private Date dateBirth;
	private Sex sexPerson;
	private String mobile;
	private String email;

	@Size(max = 255)
	@Column(name = "name", nullable = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Size(max = 255)
	@Column(name = "surname", nullable = true)
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Size(max = 9)
	@Column(name = "nif", nullable = true)
	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	@Column(name = "dateBirth", nullable = true)
	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "sexPerson", nullable = true)
	public Sex getSexPerson() {
		return sexPerson;
	}

	public void setSexPerson(Sex sexPerson) {
		this.sexPerson = sexPerson;
	}

	@Size(max = 255)
	@Column(name = "mobile", nullable = true)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Size(max = 255)
	@Column(name = "email", nullable = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
