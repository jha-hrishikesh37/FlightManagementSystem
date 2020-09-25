package com.capg.flightMgmtSystem.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capg.flightMgmtSystem.entities.Airport;
import com.capg.flightMgmtSystem.entities.Flight;
import com.capg.flightMgmtSystem.entities.Schedule;
import com.capg.flightMgmtSystem.entities.ScheduledFlight;


public interface ScheduledFlightService {

	List<ScheduledFlight> viewScheduledFlights(Airport sourceAirport, Airport destinationAirport);
	ScheduledFlight viewScheduledFlights(Long scheduledFlightId);
	List<ScheduledFlight> viewScheduledFlight();
	
}
