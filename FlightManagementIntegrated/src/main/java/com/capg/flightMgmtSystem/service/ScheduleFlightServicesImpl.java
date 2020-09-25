package com.capg.flightMgmtSystem.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.flightMgmtSystem.entities.Airport;
import com.capg.flightMgmtSystem.entities.Flight;
import com.capg.flightMgmtSystem.entities.Schedule;
import com.capg.flightMgmtSystem.entities.ScheduledFlight;
import com.capg.flightMgmtSystem.repositories.ScheduleRepository;
import com.capg.flightMgmtSystem.repositories.ScheduledFlightRepository;

@Service
public class ScheduleFlightServicesImpl implements ScheduledFlightService {
	
	@Autowired
	ScheduledFlightRepository scheduleFLightRepository;

//	@Override
//	public List<ScheduledFlight> viewScheduledFlights(Airport sourceAirport, Airport destinationAirport) {
////		List<ScheduledFlight> sclFlight = scheduleFLightRepository.findFlight(sourceAirport,destinationAirport);
////		return sclFlight;
//	}

	@Override
	public ScheduledFlight viewScheduledFlights(Long scheduledFlightId) {
		ScheduledFlight sclFLight = scheduleFLightRepository.findById(scheduledFlightId).get();
		return sclFLight;
	}

	@Override
	public List<ScheduledFlight> viewScheduledFlight() {
		
		List<ScheduledFlight>allScheduleFlights = scheduleFLightRepository.findAll();
		return allScheduleFlights;
	}

	@Override
	public List<ScheduledFlight> viewScheduledFlights(Airport sourceAirport, Airport destinationAirport) {
		// TODO Auto-generated method stub
		return null;
	}

}


