package com.capg.flightMgmtSystem.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capg.flightMgmtSystem.entities.Flight;
import com.capg.flightMgmtSystem.exceptions.NotFound_EmptyRepoException;

public interface FlightService {

	Flight viewFlight(Long flightId) throws NotFound_EmptyRepoException;
	List<Flight> viewFlight() throws NotFound_EmptyRepoException;
}
