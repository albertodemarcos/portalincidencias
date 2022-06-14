package es.incidenceapp.ms.components;

import es.incidenceapp.ms.domain.dtos.ActionResponse;
import es.incidenceapp.ms.domain.dtos.IFilter;

public interface IHttpMicroserviceService {

	ActionResponse getEntity(final Long entityId, final String typeEntity, final String entityName);
	
	ActionResponse saveEntity(final Object objectDto, final String microserviceName, final String entityName);
	
	ActionResponse deleteEntity(Long entityId, final String microserviceName, final String entityName);
	
	ActionResponse listEntities(final IFilter filters, final String microserviceName, final String entityName);
}
