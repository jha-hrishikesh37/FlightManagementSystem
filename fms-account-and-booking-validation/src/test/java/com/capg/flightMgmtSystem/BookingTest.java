package com.capg.flightMgmtSystem;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.capg.flightMgmtSystem.entities.Airport;
import com.capg.flightMgmtSystem.entities.Booking;
import com.capg.flightMgmtSystem.entities.Flight;
import com.capg.flightMgmtSystem.entities.Passenger;
import com.capg.flightMgmtSystem.entities.Schedule;
import com.capg.flightMgmtSystem.entities.ScheduledFlight;
import com.capg.flightMgmtSystem.entities.User;
import com.capg.flightMgmtSystem.repositories.BookingRepository;
import com.capg.flightMgmtSystem.service.BookingService;

class BookingTest {
	
	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	BookingService bookingService;
	
	/*************************************** Test for Booking Flight **************************************/
	
	  @Test()
	  public final void bookingFlight() throws NullPointerException, ParseException {
		  String sDate1="25/09/2020";  
		  
		  java.util.Date javaDate= new java.util.Date();
		  Date date1= new Date(javaDate.getDate());
		  
		  User user = new User(new Long("1"), "passenger", "Dhanu", "Dhanu@123", new Long("7028807607"), "dhanashreesonaje9011@gmail.com");
		  Passenger passenger = new Passenger(new Long("1"), "Amit", 18, new Long("123456"), 4);
		  
		  Airport airport1= new Airport("A101","Spain","Spain Airport");
		  Airport airport2= new Airport("A102","India","IGI Airport");
		  Flight flight= new Flight(new Long("101"),"C101","M101",200);
		  Schedule schedule = new Schedule(new Long("101"), date1, date1, airport1, airport2);
		  
		  ScheduledFlight sFlight1 = new ScheduledFlight();
		  assertNotNull(sFlight1);
		  ScheduledFlight sFlight3= new ScheduledFlight(new Long("101"),120,schedule,flight);
		  
		  Booking booking1 = new Booking(new Long("1"), date1, 10000, 4, user, passenger, sFlight3);
		  Booking booking2 = new Booking(new Long("1"), date1, 10000, 4, user, passenger, sFlight3);
		  assertTrue(booking1.equals(booking2));
		  
	  }
	  
	  public Booking getBooking() throws ParseException {
			String sDate1 = "18/09/2020";
			java.util.Date javaDate= new java.util.Date();
			  Date date1= new Date(javaDate.getDate());
			
			User user = new User(new Long("1"), "passenger", "Hrishi", "username1", new Long("8945623554"), "abc@gmail.com");
			Passenger passenger = new Passenger(new Long("1"), "Amit", 18, new Long("123456"), 4);
			  
			Airport airport1= new Airport("A101","Spain","Spain Airport");
			Airport airport2= new Airport("A102","India","IGI Airport");
			Flight flight= new Flight(new Long("101"),"C101","M101",200);
			Schedule schedule = new Schedule(new Long("101"), date1, date1, airport1, airport2);

			ScheduledFlight sFlight3= new ScheduledFlight(new Long("101"),120,schedule,flight);
	  
			Booking booking = new Booking(new Long("1"), date1, 10000, 4, user, passenger, sFlight3);
		
			return booking;
		} 
		
		public Booking getUpdatedBooking() throws ParseException {
			String sDate1 = "18/09/2020";
			java.util.Date javaDate= new java.util.Date();
			  Date date1= new Date(javaDate.getDate());
			  
			User user = new User(new Long("1"), "passenger", "Hrishikesh", "username2", new Long("7028807607"), "abc@gmail.com");
			Passenger passenger = new Passenger(new Long("1"), "Amit", 18, new Long("123456"), 4);
			  
			Airport airport1= new Airport("A101","Spain","Spain Airport");
			Airport airport2= new Airport("A102","India","IGI Airport");
			Flight flight= new Flight(new Long("101"),"C101","M101",200);
			Schedule schedule = new Schedule(new Long("101"), date1, date1, airport1, airport2);

			ScheduledFlight sFlight3= new ScheduledFlight(new Long("101"),120,schedule,flight);
	  
			Booking booking = new Booking(new Long("1"), date1, 10000, 4, user, passenger, sFlight3);
		
			return booking;
		} 
		
		@Test
		public final void testSearchingBooking() throws ParseException {
			Booking booking1 = getBooking();

		  bookingRepository.save(booking1);
		  
		  ResponseEntity<?> responseEntity =  bookingService.findBookingById(new Long("1"));
		  assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
		}
		
		@Test
		public final void testCancelBooking() throws ParseException {
			Booking booking2 = getBooking();
			
			bookingRepository.save(booking2);
			  
			ResponseEntity<?> responseEntity =  bookingService.deleteBooking(new Long("1"));
			assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);

		}
		
		@Test
		public final void testUpdateBooking() throws ParseException {
			Booking booking3 = getBooking();
			
			bookingRepository.save(booking3);
			
			Booking updatedBooking = getUpdatedBooking();
			
			ResponseEntity<?> responseEntity = bookingService.updateBooking(updatedBooking);
			assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
		}
	
}
