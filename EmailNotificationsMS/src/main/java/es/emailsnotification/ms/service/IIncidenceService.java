package es.emailsnotification.ms.service;

import java.util.Date;
import java.util.List;

import es.emailsnotification.ms.domain.Incidence;

public interface IIncidenceService {

	List<Incidence> getIncidencesOnDateAndHoursNow(Date todayDate);
}
