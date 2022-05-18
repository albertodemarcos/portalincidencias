package es.incidencias.ms.domain.entities.organization.impl;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import es.incidencias.ms.domain.entities.organization.Company;
import es.incidencias.ms.domain.entities.organization.IOrganization;


@Entity
@Table(name = "jhi_townhall")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class TownHall extends Company implements IOrganization {

}
