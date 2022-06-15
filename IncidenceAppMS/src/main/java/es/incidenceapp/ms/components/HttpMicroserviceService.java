package es.incidenceapp.ms.components;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import es.incidenceapp.ms.config.profile.PortUrlProfile;
import es.incidenceapp.ms.domain.dtos.ActionResponse;
import es.incidenceapp.ms.domain.dtos.IFilter;


@Component
public class HttpMicroserviceService implements IHttpMicroserviceService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private PortUrlProfile portUrlProfile;
	
	@Autowired
    private RestTemplate httpTemplate;
	
	
	@Override
	public ActionResponse getEntity(Long entityId, final String microserviceName, final String entityName) {
		// TODO Auto-generated method stub
		
		String _url = getUrlEntity(entityId, microserviceName, entityName);
		
		if( StringUtils.isBlank(_url) )
		{	
			logger.error("Error. URL={}", _url);
			return new ActionResponse(MicroserviceConstans.NOK, "Internal error!");
		}
		
		HttpEntity<?> _params = this.getParamsURL();
		
		ActionResponse _response = this.sendHttpRequest(_url, _params, HttpMethod.GET);
		
		return _response;
	}

	@Override
	public ActionResponse saveEntity(Object objectDto, final String microserviceName, final String entityName) {
		// TODO Auto-generated method stub
		String _url = this.getUrlSaveEntity(microserviceName, entityName);
		
		if( StringUtils.isBlank(_url) )
		{	
			logger.error("Error. URL={}", _url);
			return new ActionResponse(MicroserviceConstans.NOK, "Internal error!");
		}
		
		HttpEntity<?> _params = this.postParamsURL(objectDto);
		
		ActionResponse _response = sendHttpRequest(_url, _params, HttpMethod.POST);
		
		return _response;
	}

	@Override
	public ActionResponse deleteEntity(Long entityId, final String microserviceName, final String entityName) {
		// TODO Auto-generated method stub

		String _url = getUrlDeleteEntity(entityId, microserviceName, entityName);
		
		if( StringUtils.isBlank(_url) )
		{	
			logger.error("Error. URL={}", _url);
			return new ActionResponse(MicroserviceConstans.NOK, "Internal error!");
		}
		
		HttpEntity<?> _params = this.getParamsURL();
		
		ActionResponse _response = this.sendHttpRequest(_url, _params, HttpMethod.GET);
		
		return _response;
	}

	@Override
	public ActionResponse listEntities(IFilter filters, final String microserviceName, final String entityName) {
		// TODO Auto-generated method stub

		String _url = this.getUrlListEntities(microserviceName, entityName);
		
		if( StringUtils.isBlank(_url) )
		{	
			logger.error("Error. URL={}", _url);
			return new ActionResponse(MicroserviceConstans.NOK, "Internal error!");
		}
		
		HttpEntity<?> _params = this.postParamsURL(filters);
		
		ActionResponse _response = sendHttpRequest(_url, _params, HttpMethod.POST);
		
		return _response;
	}
	
	
	private HttpEntity<?> getParamsURL() {
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
		
		HttpEntity<?> httpEntity = new HttpEntity<Object>(headers);
		
		return httpEntity;
	}
	
	private HttpEntity<?> postParamsURL(final Object objectDto) {
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
		
		HttpEntity<?> httpEntity = new HttpEntity<Object>(objectDto, headers);
		
		return httpEntity;
	}
	
	private String getCreateUrl(final String _head, final String _microserviceName, final String _uri)
	{
		logger.info("Method: HttpMicroserviceService.createUrl(_head={}, _microserviceName={}, uri={})",_head, _microserviceName, _uri);		
		
		if( StringUtils.isBlank(_head) || StringUtils.isBlank(_microserviceName) || StringUtils.isBlank(_uri) )
		{			
			logger.error("Error. The params of URL is null");
			return null;
		}		
		String _url = _head + portUrlProfile.getPortUrl(_microserviceName) + _uri;		
		
		logger.info("Method: HttpMicroserviceService.createUrl()=> _url={}", _url);		
		return _url;
	
	}
	

	private ActionResponse sendHttpRequest(String _url, HttpEntity<?> _params, HttpMethod _httpMethod) {
		
		ActionResponse _response = null;
		
		try 
		{
			 ResponseEntity<ActionResponse> _responseHttp = this.httpTemplate.exchange(_url, _httpMethod, _params, ActionResponse.class);
			
			if( _responseHttp != null ) {
			
				return _responseHttp.getBody();
			}
		}
		catch(RestClientException e) 
		{
			logger.error("The microservice is not working. Try again on five minutes");
			e.printStackTrace();
			_response = new ActionResponse(MicroserviceConstans.NOK, "The microservice is not working. Try again on five minutes");
		}
		catch(Exception e) 
		{
			logger.error("The microservice is not working. Try again on five minutes");
			e.printStackTrace();
			_response = new ActionResponse(MicroserviceConstans.NOK, "The microservice is not working. Try again on five minutes");
		}
		
		return _response;
	}
	
	private String getUrlEntity(Long entityId, final String microserviceName, final String entityName) {
		String _uri = null;
		
		switch(entityName) 
		{
		case MicroserviceConstans.INCIDENCE:
			_uri = MicroserviceConstans.URL_MICROSERVICE_PORTAL_INCIDENCE_GET_INCIDENCE + entityId.toString();
			break;
		case MicroserviceConstans.ORGANIZATION:
			_uri = MicroserviceConstans.URL_MICROSERVICE_PORTAL_INCIDENCE_GET_ORGANIZATION + entityId.toString();
			break;
		case MicroserviceConstans.EMPLOYEE:
			_uri = MicroserviceConstans.URL_MICROSERVICE_PORTAL_INCIDENCE_GET_EMPLOYEE + entityId.toString();
			break;
		default:
			
			break;			
		}
		
		String _url = this.getCreateUrl(MicroserviceConstans.URL_GENERAL, microserviceName, _uri );
		
		return _url;
	}
	
	private String getUrlSaveEntity(final String microserviceName, final String entityName) {
		
		String _uri = null;
		
		switch(entityName) 
		{
		case MicroserviceConstans.INCIDENCE:
			_uri = MicroserviceConstans.URL_MICROSERVICE_PORTAL_INCIDENCE_CREATE_INCIDENCE;
			break;
		case MicroserviceConstans.ORGANIZATION:
			_uri = MicroserviceConstans.URL_MICROSERVICE_PORTAL_INCIDENCE_CREATE_ORGANIZATION;
			break;
		case MicroserviceConstans.EMPLOYEE:
			_uri = MicroserviceConstans.URL_MICROSERVICE_PORTAL_INCIDENCE_CREATE_EMPLOYEE;
			break;
		default:
			
			break;			
		}
		
		String _url = this.getCreateUrl(MicroserviceConstans.URL_GENERAL, microserviceName, _uri );
		
		return _url;
	}
	
	private String getUrlDeleteEntity(Long entityId, final String microserviceName, final String entityName) {
		String _uri = null;
		
		switch(entityName) 
		{
		case MicroserviceConstans.INCIDENCE:
			_uri = MicroserviceConstans.URL_MICROSERVICE_PORTAL_INCIDENCE_DELETE_INCIDENCE + entityId.toString();
			break;
		case MicroserviceConstans.ORGANIZATION:
			_uri = MicroserviceConstans.URL_MICROSERVICE_PORTAL_INCIDENCE_DELETE_ORGANIZATION + entityId.toString();
			break;
		case MicroserviceConstans.EMPLOYEE:
			_uri = MicroserviceConstans.URL_MICROSERVICE_PORTAL_INCIDENCE_DELETE_EMPLOYEE + entityId.toString();
			break;
		default:
			
			break;			
		}
		
		String _url = this.getCreateUrl(MicroserviceConstans.URL_GENERAL, microserviceName, _uri );
		
		return _url;
	}
	
	private String getUrlListEntities(final String microserviceName, final String entityName) {
		String _uri = null;
		
		switch(entityName) 
		{
		case MicroserviceConstans.INCIDENCE:
			_uri = MicroserviceConstans.URL_MICROSERVICE_PORTAL_INCIDENCE_LIST_INCIDENCES;
			break;
		case MicroserviceConstans.ORGANIZATION:
			_uri = MicroserviceConstans.URL_MICROSERVICE_PORTAL_INCIDENCE_LIST_ORGANIZATIONS;
			break;
		case MicroserviceConstans.EMPLOYEE:
			_uri = MicroserviceConstans.URL_MICROSERVICE_PORTAL_INCIDENCE_LIST_EMPLOYEES;
			break;
		default:
			
			break;			
		}
		
		String _url = this.getCreateUrl(MicroserviceConstans.URL_GENERAL, microserviceName, _uri );
		
		return _url;
	}
	
}
