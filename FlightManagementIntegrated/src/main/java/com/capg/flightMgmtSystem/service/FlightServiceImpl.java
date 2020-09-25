package com.capg.flightMgmtSystem.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capg.flightMgmtSystem.entities.Flight;
import com.capg.flightMgmtSystem.exceptions.NotFound_EmptyRepoException;
import com.capg.flightMgmtSystem.exceptions.UserAlreadyExistsException;
import com.capg.flightMgmtSystem.repositories.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {
	
	Logger logger = LoggerFactory.getLogger(FlightServiceImpl.class);

	@Autowired
	FlightRepository flightRepository;

	/*************************************** View Flight with ID **************************************/
	
	@Override
	public Flight viewFlight(Long flightId) throws NotFound_EmptyRepoException  {
		Flight flight = flightRepository.findById(flightId).orElseThrow(() -> new
				  NotFound_EmptyRepoException("Flight not found for this id : " + flightId));

		logger.info("View Flight: ", flight);
		return flight;
		}
	
	/*************************************** View All Flights **************************************/
	
	@Override
	public List<Flight> viewFlight() throws NotFound_EmptyRepoException {
		List<Flight> flight = flightRepository.findAll();
		logger.info("View All Flights: "+flight);
		if(flight.isEmpty()) {
			throw new NotFound_EmptyRepoException("Sorry, There are No schedule Flights.");
		}
		else {
			return flight;
		}
	}
	
	/*************************************** Add Flight **************************************/
	
	@Override
	public ResponseEntity<Flight> addFlight(Flight flight) {
		Optional<Flight> findById = flightRepository.findById(flight.getFlightNumber());
		try {
			if (!findById.isPresent()) {
				flightRepository.save(flight);
				return new ResponseEntity<Flight>(flight,HttpStatus.OK);
			} else
				throw new UserAlreadyExistsException("Flight with number: " + flight.getFlightNumber() + " already present");
		}
		catch(UserAlreadyExistsException e)
		{
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
