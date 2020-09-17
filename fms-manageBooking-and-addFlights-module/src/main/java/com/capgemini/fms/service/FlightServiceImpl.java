package com.capgemini.fms.service;

import java.math.BigInteger;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.capgemini.fms.dao.FlightDao;
import com.capgemini.fms.entities.Flight;
import com.capgemini.fms.exceptions.RecordAlreadyPresentException;

@Service
public class FlightServiceImpl implements FlightService {
	@Autowired
	FlightDao flightDao;

	@Override
	public ResponseEntity<Flight> addFlight(Flight flight) {
		Optional<Flight> findById = flightDao.findById(flight.getFlightNo());
		try {
			if (!findById.isPresent()) {
				flightDao.save(flight);
				return new ResponseEntity<Flight>(flight,HttpStatus.OK);
			} else
				throw new RecordAlreadyPresentException("Flight with number: " + flight.getFlightNo() + " already present");
		}
		catch(RecordAlreadyPresentException e)
		{
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Iterable<Flight> viewAllFlight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flight viewFlight(BigInteger flightNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flight modifyFlight(Flight flight) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeFlight(BigInteger flightNumber) {
		// TODO Auto-generated method stub
		return null;
	}


}
