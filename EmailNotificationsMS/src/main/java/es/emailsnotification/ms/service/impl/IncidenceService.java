package es.emailsnotification.ms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import es.emailsnotification.ms.domain.Incidence;
import es.emailsnotification.ms.service.IIncidenceService;

@Service
public class IncidenceService implements IIncidenceService {

	@Override
	public List<Incidence> getIncidencesOnDateAndHoursNow(Date todayDate) {
		// TODO Auto-generated method stub
		
		return null;
	}

}
