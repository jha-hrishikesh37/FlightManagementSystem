package com.capg.flightMgmtSystem.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capg.flightMgmtSystem.entities.Booking;
import com.capg.flightMgmtSystem.entities.Flight;
import com.capg.flightMgmtSystem.entities.User;
import com.capg.flightMgmtSystem.exceptions.EmptyRepositoryException;
import com.capg.flightMgmtSystem.exceptions.InsufficientSeatsException;
import com.capg.flightMgmtSystem.exceptions.NotFoundException;
import com.capg.flightMgmtSystem.exceptions.UserAlreadyExistsException;
import com.capg.flightMgmtSystem.service.BookingService;
import com.capg.flightMgmtSystem.service.FlightService;
import com.capg.flightMgmtSystem.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/fms/user",method= {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT})	//Base URL
public class RestApiController {
	
	org.slf4j.Logger logger = LoggerFactory.getLogger(RestApiController.class);	
	
	@Autowired
    UserService userService;
	
	@Autowired
	FlightService flightService;
	
	@Autowired
	BookingService bookingService;
	
	/*************************************** Register User **************************************/
	
	@PostMapping("/registerUser")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws MessagingException, UserAlreadyExistsException			
    {
		logger.info("Add user working...");
     
			userService.addUser(user);
            return ResponseEntity.ok(HttpStatus.OK);
    }
	
	/*************************************** Add Flight **************************************/
	
	@PostMapping("/addFlight")
	public ResponseEntity<?> addFlight(@RequestBody Flight flight) {
		return flightService.addFlight(flight);
	}
	
	/*************************************** Check Flight Availability **************************************/
	
	/*************************************** View Flight with ID **************************************/
	
	@GetMapping("/viewFlight/{flightNumber}")
	public ResponseEntity<Flight> viewFlight(@PathVariable("flightNumber") Long flightId) throws NotFoundException {
		logger.info("Flight with Id displayed");
		Flight flight = flightService.viewFlight(flightId);
		return new ResponseEntity<Flight>(flight, HttpStatus.OK);
	}
	
	/*************************************** View All Flights **************************************/
	
	@GetMapping("/viewAllFlights")
	 public ResponseEntity<List<Flight>> viewAllFlights() throws EmptyRepositoryException{
		logger.info("All flights will be displayed");
		List<Flight> flights= flightService.viewFlight();
			return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK);		
	}
	
	/*************************************** Flight Booking**************************************/
	
	@PostMapping("/booking")
	 public ResponseEntity<?> passengerBooking(@RequestBody Booking booking) throws MessagingException, UserAlreadyExistsException, InsufficientSeatsException
    {
		    logger.info("Add booking working...");
		    bookingService.addBooking(booking);
            return ResponseEntity.ok(HttpStatus.OK);
    }
	
	
	/*************************************** View All Bookings **************************************/
	
	@GetMapping("/readAllBooking")
	public Iterable<Booking> readAllBookings() {

		return bookingService.displayAllBooking();
	}

	/*************************************** Update Booking **************************************/
	
	@PutMapping("/updateBooking")
	public ResponseEntity<?> modifyBooking(@RequestBody Booking updateBooking) {

		return bookingService.updateBooking(updateBooking);
	}
	
	/*************************************** Search Booking **************************************/

	@GetMapping("/searchBooking/{id}")
	public ResponseEntity<?> searchBookingByID(@PathVariable("id") Long bookingId) {

		return bookingService.findBookingById(bookingId);
	}

	/*************************************** Delete Booking **************************************/
	
	@DeleteMapping("/deleteBooking/{id}")
	public ResponseEntity<?> deleteBookingByID(@PathVariable("id") Long bookingId) {

		return bookingService.deleteBooking(bookingId);
	}
	
	
}

