package es.emailsnotification.ms.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.emailsnotification.ms.domain.Incidence;
import es.emailsnotification.ms.service.IEmailNotificationService;

@Service
public class EmailNotificationService implements IEmailNotificationService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IncidenceService incidenceService;
	
	@Override
	public void sendEmailsNotificationIncidences() {
		// TODO Auto-generated method stub
		
		Date todayDate = new Date();
		
		logger.info("Today={} go to notification user's incidences", todayDate);
		
		List<Incidence> incidences = this.incidenceService.getIncidencesOnDateAndHoursNow( todayDate );
		
		for(Incidence incidence : incidences) 
		{
			this.sendUserNotification(incidence);
		}
	}
	
	/**
	 * Method for send email
	 * 
	 * @param event
	 */
	private void sendUserNotification(Object event) {
		
		
		
	}

}
