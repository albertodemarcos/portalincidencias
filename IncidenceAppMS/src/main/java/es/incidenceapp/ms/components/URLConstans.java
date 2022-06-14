package es.incidenceapp.ms.components;

/**
 * Application constants.
 */
public final class URLConstans {
	
	public static final String NOK = "-1";
    public static final String OK = "1";
    
    //APIS
    public static final String PORTAL_INCIDENCE = "PORTAL_INCIDENCE";
	public static final String EMAILSMS = "EMAILSMS";
	public static final String NOTIFICATIONSMS = "NOTIFICATIONSMS";
	
	//ENTITIES
	public static final String INCIDENCE = "INCIDENCE";
	public static final String ORGANIZATION = "ORGANIZATION";
	public static final String EMPLOYEE = "EMPLOYEE";
	
	
	//URL
	public static final String URL_GENERAL = "http://IncidenceApiMsApp:";
	
	
	
	public static final String URL_MICROSERVICE_PORTAL_INCIDENCE_GET_INCIDENCE = "/incidenceApi/task/";
	public static final String URL_MICROSERVICE_PORTAL_INCIDENCE_CREATE_INCIDENCE = "/incidenceApi/task";
	public static final String URL_MICROSERVICE_PORTAL_INCIDENCE_DELETE_INCIDENCE = "/incidenceApi/task/";
	public static final String URL_MICROSERVICE_PORTAL_INCIDENCE_LIST_INCIDENCES = "/incidenceApi/list";
	
	public static final String URL_MICROSERVICE_PORTAL_INCIDENCE_GET_ORGANIZATION = "/incidenceApi/task/";
	public static final String URL_MICROSERVICE_PORTAL_INCIDENCE_CREATE_ORGANIZATION = "/incidenceApi/task";
	public static final String URL_MICROSERVICE_PORTAL_INCIDENCE_DELETE_ORGANIZATION = "/incidenceApi/task/";
	public static final String URL_MICROSERVICE_PORTAL_INCIDENCE_LIST_ORGANIZATIONS = "/incidenceApi/list";
	
	public static final String URL_MICROSERVICE_PORTAL_INCIDENCE_GET_EMPLOYEE = "/incidenceApi/task/";
	public static final String URL_MICROSERVICE_PORTAL_INCIDENCE_CREATE_EMPLOYEE = "/incidenceApi/task";
	public static final String URL_MICROSERVICE_PORTAL_INCIDENCE_DELETE_EMPLOYEE = "/incidenceApi/task/";
	public static final String URL_MICROSERVICE_PORTAL_INCIDENCE_LIST_EMPLOYEES = "/incidenceApi/list";

    private URLConstans() {}

}
