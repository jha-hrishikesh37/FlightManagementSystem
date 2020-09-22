/*
 * Project Name : Flight Management System
 *
 * 
 * */

package com.capgemini.fms.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.fms.entities.Flight;
import com.capgemini.fms.exceptions.RecordAlreadyPresentException;
import com.capgemini.fms.service.FlightService;

/**
* The FlightController class implements addFlight method
*
* @author   :Hrishikesh Jha
* @version  :1.0
* @since    :2020-09-20 
*/

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/flight")
public class FlightController {
	@Autowired(required = true)
	FlightService flightService;

	@PostMapping("/addFlight")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<?> addFlight(@RequestBody Flight flight) {
		return flightService.addFlight(flight);
	}

}
