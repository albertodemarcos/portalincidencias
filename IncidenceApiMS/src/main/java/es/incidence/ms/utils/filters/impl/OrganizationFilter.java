package es.incidence.ms.utils.filters.impl;

import java.io.Serializable;

import es.incidence.ms.domain.enums.OrganizationType;
import es.incidence.ms.utils.filters.IFilter;

public class OrganizationFilter implements IFilter, Serializable {

	private static final long serialVersionUID = -8214772322155949547L;

	private String nombre;
	private String descripcion;
	private OrganizationType tipo;

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
