package com.capg.flightMgmtSystem.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capg.flightMgmtSystem.entities.Booking;
import com.capg.flightMgmtSystem.entities.Flight;
import com.capg.flightMgmtSystem.entities.User;
import com.capg.flightMgmtSystem.exceptions.EmptyRepositoryException;
import com.capg.flightMgmtSystem.exceptions.UserAlreadyExistsException;
import com.capg.flightMgmtSystem.service.BookingService;
import com.capg.flightMgmtSystem.service.FlightService;
import com.capg.flightMgmtSystem.service.UserService;

@RestController
@RequestMapping(value="/bootcamp/user",method= {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT})
public class RestApiController {
	
	org.slf4j.Logger logger = LoggerFactory.getLogger(RestApiController.class);	
	
	@Autowired
    UserService userService;
	
	@Autowired
	FlightService flightService;
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/registerUser")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws MessagingException, UserAlreadyExistsException
    {
		logger.trace("Add user working...");
     
			userService.addUser(user);
            return ResponseEntity.ok(HttpStatus.OK);
    }
	
	@GetMapping("/viewFlight/{flightNumber}")
	public ResponseEntity<Flight> viewFlight(@PathVariable("flightNumber") Long flightId){
		Flight flight = flightService.viewFlight(flightId);
		return new ResponseEntity<Flight>(flight, HttpStatus.OK);
	}
	
	@GetMapping("/viewAllFlights")
	 public ResponseEntity<List<Flight>> viewAllFlights() throws EmptyRepositoryException{
		List<Flight> flights= flightService.viewFlight();
			return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK);		
	}
	
	@PostMapping("/booking")
	 public ResponseEntity<?> passengerBooking(@RequestBody Booking booking) throws MessagingException, UserAlreadyExistsException
    {
		    logger.trace("Add booking working...");
		    bookingService.addBooking(booking);
            return ResponseEntity.ok(HttpStatus.OK);
    }
	
	@GetMapping("/viewAllBookings")
	 public ResponseEntity<List<Booking>> viewAllBookings() throws EmptyRepositoryException{
		List<Booking> books = bookingService.viewBooking();
			return new ResponseEntity<List<Booking>>(books, HttpStatus.OK);		
		}
	
	@GetMapping("/viewBookings/{bookingId}")
	 public ResponseEntity<Booking> viewBookings(@PathVariable("bookingId") Long id) throws EmptyRepositoryException{
		Booking books = bookingService.viewBooking(id);
			return new ResponseEntity<Booking>(books, HttpStatus.OK);		
		}
	
}
