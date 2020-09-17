package com.capg.flightMgmtSystem.service;

import java.util.List;

import com.capg.flightMgmtSystem.entities.Flight;
import com.capg.flightMgmtSystem.exceptions.EmptyRepositoryException;

public interface FlightService {

	Flight viewFlight(Long flightId);
	List<Flight> viewFlight() throws EmptyRepositoryException;
}


