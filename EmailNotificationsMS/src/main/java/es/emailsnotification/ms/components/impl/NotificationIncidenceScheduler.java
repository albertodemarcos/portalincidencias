package es.emailsnotification.ms.components.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import es.emailsnotification.ms.components.INotificationIncidenceScheduler;

@Component
public class NotificationIncidenceScheduler implements INotificationIncidenceScheduler {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	@Override
	//@Scheduled(cron = "0/5 * * * * ?")
    //@SchedulerLock(name = "emailsnotificationms_sendemails_notification_incidences")
	public void incidencesNotificationUsersScheduledTask() {
		// TODO Auto-generated method stub
		
		logger.info("Se va a realizar el envio de notificaciones a los usuarios");
		
		//this.notificationsService.sendUsersNotifications();	
	}

}
