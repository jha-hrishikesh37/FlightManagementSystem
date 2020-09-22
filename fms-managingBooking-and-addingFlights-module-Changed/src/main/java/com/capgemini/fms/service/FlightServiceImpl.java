package com.capgemini.fms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.fms.entities.Flight;
import com.capgemini.fms.exceptions.RecordAlreadyPresentException;
import com.capgemini.fms.repositories.FlightRepository;



@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightRepository flightRepository;

	/**
	   * This method is used to add the flights to the database. 
	   * @param flight       :This is the paramter of type Flight
	   * @return ResponseEntity : This returns Flight object, else throws an exception
	   */
		
	@Override
	public ResponseEntity<Flight> addFlight(Flight flight) {
		Optional<Flight> findById = flightRepository.findById(flight.getFlightNumber());
		try {
			if (!findById.isPresent()) {
				flightRepository.save(flight);
				return new ResponseEntity<Flight>(flight,HttpStatus.OK);
			} else
				throw new RecordAlreadyPresentException("Flight with number: " + flight.getFlightNumber() + " already present");
		}
		catch(RecordAlreadyPresentException e)
		{
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}


