package es.incidenceapp.ms.config.profile.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import es.incidenceapp.ms.config.profile.PortUrlProfile;


@Component
@Profile("dev")
public class DevPortUrlProfile implements PortUrlProfile {

	private static final String PORT_DEV = "8085";
	
	private static final String PORT_DEV_PORTAL_INCIDENCE_RMS = "8085";
	private static final String PORT_DEV_EMAILSMS = "8085";
	private static final String PORT_DEV_NOTIFICATIONSMS = "8085";
	
	private static final String PORTAL_INCIDENCE = "PORTAL_INCIDENCE";
	private static final String EMAILSMS = "EMAILSMS";
	private static final String NOTIFICATIONSMS = "NOTIFICATIONSMS";
	
	
	@Override
	public String getPortUrl(final String microservicePort) 
	{
		// TODO Auto-generated method stub
		String portUrl = PORT_DEV;
		
		switch(microservicePort) 
		{
		case PORTAL_INCIDENCE:
			portUrl = PORT_DEV_PORTAL_INCIDENCE_RMS;
			break;
		case EMAILSMS:
			portUrl = PORT_DEV_EMAILSMS;
			break;
		case NOTIFICATIONSMS:
			portUrl = PORT_DEV_NOTIFICATIONSMS;
			break;
		default:
			portUrl = PORT_DEV;
			break;			
		}
		
		return portUrl;
	}

}
