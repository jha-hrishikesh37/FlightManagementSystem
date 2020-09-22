package com.capgemini.fms.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capgemini.fms.entities.Flight;


public interface FlightService {

	public ResponseEntity<?> addFlight(Flight flight);

}

