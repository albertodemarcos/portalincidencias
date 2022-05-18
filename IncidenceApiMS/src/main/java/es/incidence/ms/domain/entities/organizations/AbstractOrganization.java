package es.incidence.ms.domain.entities.organizations;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractOrganization {

	private String nombre;
	private String descripcion;

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

}
