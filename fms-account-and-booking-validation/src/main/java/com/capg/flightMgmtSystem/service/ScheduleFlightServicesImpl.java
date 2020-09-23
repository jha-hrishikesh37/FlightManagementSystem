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

	@Override
	public List<ScheduledFlight> viewScheduledFlights(Airport sourceAirport, Airport destinationAirport,
			LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScheduledFlight viewScheduledFlights(Long scheduledFlightId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScheduledFlight> viewScheduledFlight() {
		
		List<ScheduledFlight>allScheduleFlights = scheduleFLightRepository.findAll();
		return allScheduleFlights;
	}

}


