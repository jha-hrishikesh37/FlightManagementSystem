package com.capg.flightMgmtSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.flightMgmtSystem.entities.Flight;
import com.capg.flightMgmtSystem.exceptions.EmptyRepositoryException;
import com.capg.flightMgmtSystem.repositories.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightRepository flightRepository;

	@Override
	public Flight viewFlight(Long flightId) {
		Flight flight = flightRepository.findById(flightId).get();
		return flight;
	}

	@Override
	public List<Flight> viewFlight() throws EmptyRepositoryException {
		List<Flight> flight = flightRepository.findAll();
		if(flight.isEmpty()) {
			throw new EmptyRepositoryException("Sorry, There are No schedule Flights.");
		}
		else {
			return flight;
		}
	}
}