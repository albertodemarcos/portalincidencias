package es.incidence.ms.domain.dtos;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

public class EmployeeFilterDTO implements Serializable, IFilter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5826227227285650540L;
	
	private Long id;
	private String login;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private Boolean activated;
	private String langKey;
	private String imageUrl;
	private String activationKey;
	private String resetKey;
	private Instant resetDate;
	private String typeUser;
	private Long organizationId;
	private String employeeIdentificationNumber;
	private String alias;
	private Set<Long> authoritiesId;
	
	public EmployeeFilterDTO() {
		super();
	}
	

	public EmployeeFilterDTO(Long id, String login, String password, String firstName, String lastName, String email,
			Boolean activated, String langKey, String imageUrl, String activationKey, String resetKey,
			Instant resetDate, String typeUser, Long organizationId, String employeeIdentificationNumber, String alias,
			Set<Long> authoritiesId) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.activated = activated;
		this.langKey = langKey;
		this.imageUrl = imageUrl;
		this.activationKey = activationKey;
		this.resetKey = resetKey;
		this.resetDate = resetDate;
		this.typeUser = typeUser;
		this.organizationId = organizationId;
		this.employeeIdentificationNumber = employeeIdentificationNumber;
		this.alias = alias;
		this.authoritiesId = authoritiesId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getActivated() {
		return activated;
	}

	public void setActivated(Boolean activated) {
		this.activated = activated;
	}

	public String getLangKey() {
		return langKey;
	}

	public void setLangKey(String langKey) {
		this.langKey = langKey;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getActivationKey() {
		return activationKey;
	}

	public void setActivationKey(String activationKey) {
		this.activationKey = activationKey;
	}

	public String getResetKey() {
		return resetKey;
	}

	public void setResetKey(String resetKey) {
		this.resetKey = resetKey;
	}

	public Instant getResetDate() {
		return resetDate;
	}

	public void setResetDate(Instant resetDate) {
		this.resetDate = resetDate;
	}

	public String getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public String getEmployeeIdentificationNumber() {
		return employeeIdentificationNumber;
	}

	public void setEmployeeIdentificationNumber(String employeeIdentificationNumber) {
		this.employeeIdentificationNumber = employeeIdentificationNumber;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Set<Long> getAuthoritiesId() {
		return authoritiesId;
	}

	public void setAuthoritiesId(Set<Long> authoritiesId) {
		this.authoritiesId = authoritiesId;
	}

}
