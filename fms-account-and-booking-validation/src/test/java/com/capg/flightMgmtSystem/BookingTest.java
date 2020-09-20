package com.capg.flightMgmtSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.capg.flightMgmtSystem.entities.Airport;
import com.capg.flightMgmtSystem.entities.Booking;
import com.capg.flightMgmtSystem.entities.Flight;
import com.capg.flightMgmtSystem.entities.Passenger;
import com.capg.flightMgmtSystem.entities.Schedule;
import com.capg.flightMgmtSystem.entities.ScheduledFlight;
import com.capg.flightMgmtSystem.entities.User;

class BookingTest {

	
	/*************************************** Test for Booking Flight **************************************/
	
	  @Test()
	  public final void bookingFlight() throws NullPointerException, ParseException {
		  String sDate1="25/09/2020";  
		  Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  
		  
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
	
}
