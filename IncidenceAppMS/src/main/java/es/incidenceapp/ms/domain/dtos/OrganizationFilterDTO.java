package es.incidenceapp.ms.domain.dtos;

import java.io.Serializable;

import es.incidenceapp.ms.domain.enums.OrganizationType;

public class OrganizationFilterDTO implements Serializable, IFilter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4578913419346250386L;
	
	private Long id;
	private String nombre;
	private String descripcion;
	private OrganizationType tipo;

	public OrganizationFilterDTO() {
		super();
	}

	public OrganizationFilterDTO(Long id, String nombre, String descripcion, OrganizationType tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public OrganizationType getTipo() {
		return tipo;
	}

	public void setTipo(OrganizationType tipo) {
		this.tipo = tipo;
	}

}
