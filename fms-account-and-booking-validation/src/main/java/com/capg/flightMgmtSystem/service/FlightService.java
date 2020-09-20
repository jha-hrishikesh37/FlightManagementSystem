package com.capg.flightMgmtSystem.service;

import java.util.List;

import com.capg.flightMgmtSystem.entities.Flight;
import com.capg.flightMgmtSystem.exceptions.EmptyRepositoryException;
import com.capg.flightMgmtSystem.exceptions.NotFoundException;

public interface FlightService {

	Flight viewFlight(Long flightId) throws NotFoundException;
	List<Flight> viewFlight() throws EmptyRepositoryException;
}

