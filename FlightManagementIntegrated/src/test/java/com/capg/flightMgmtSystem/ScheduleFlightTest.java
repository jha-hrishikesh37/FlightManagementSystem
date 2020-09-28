package com.capg.flightMgmtSystem;

import static org.junit.jupiter.api.Assertions.*;


import java.text.ParseException;
import java.sql.Date;

import org.junit.jupiter.api.Test;

import com.capg.flightMgmtSystem.entities.Airport;
import com.capg.flightMgmtSystem.entities.Flight;
import com.capg.flightMgmtSystem.entities.Schedule;
import com.capg.flightMgmtSystem.entities.ScheduledFlight;

class ScheduleFlightTest {

	 /*************************************** Test for Schedule Flight **************************************/
	
	  @Test()
	  public final void scheduleFlight() throws NullPointerException, ParseException {
		  String sDate1="25/09/2020";  
		  
		  java.util.Date javaDate= new java.util.Date();
		  Date date1= new Date(javaDate.getDate()); 
		  
		  Airport airport1= new Airport("A101","Spain","Spain Airport");
		  Airport airport2= new Airport("A102","India","IGI Airport");
		  Flight flight= new Flight(new Long("101"),"C101","M101",200);
		  Schedule schedule = new Schedule(new Long("101"), date1, date1, airport1, airport2);
		  
		  ScheduledFlight sFlight1 = new ScheduledFlight();
		  assertNotNull(sFlight1);
		  ScheduledFlight sFlight2 = null;
		  ScheduledFlight sFlight3= new ScheduledFlight(new Long("101"),120,1000,schedule,flight);
		  ScheduledFlight sFlight4= new ScheduledFlight(new Long("101"),120,1000,schedule,flight);
		  assertTrue(sFlight3.equals(sFlight4));
		  assertFalse(sFlight3.equals(sFlight2));
		
	  }
	  
	  /*************************************** Test for toString Verification **************************************/
	  
	  @Test
	  public final void stringScheduleTest() throws ParseException {
		  String sDate1="25/09/2020";  
		  
		  java.util.Date javaDate= new java.util.Date();
		  Date date1= new Date(javaDate.getDate());   
		  
		  Airport airport1= new Airport("A101","Spain","Spain Airport");
		  Airport airport2= new Airport("A102","India","IGI Airport");
		  Flight flight= new Flight(new Long("101"),"C101","M101",200);
		 
		  Schedule schedule = new Schedule(new Long("101"), date1, date1, airport1, airport2);
		  
		  
		  ScheduledFlight sFlight1= new ScheduledFlight(new Long("101"),120,1000,schedule,flight);
		  String result = String.format("scheduledFlightId=" + sFlight1.getScheduledFlightId() + ", availableSeat=" + sFlight1.getAvailableSeat()+
		 ", TicketCost= "+ sFlight1.getTicketCost()+ ", \n" + schedule + ", \n" + flight,
				  sFlight1.getScheduledFlightId(), sFlight1.getFlight(), 
				  sFlight1.getAvailableSeat(), sFlight1.getSchedule()+"\n");
		  assertEquals(result, sFlight1.toString());
	  }
	  
	  
	  /*************************************** Test for Schedule Flight **************************************/
	  @Test
	  public final void testScheduledFlight() throws ParseException {
		  String sDate1="25/09/2020";  
		  
		  java.util.Date javaDate= new java.util.Date();
		  Date date1= new Date(javaDate.getDate());   
		  
		  Airport airport1= new Airport("A101","Spain","Spain Airport");
		  Airport airport2= new Airport("A102","India","IGI Airport");
		  Long b1= new Long("101");
		  Flight flight= new Flight(b1,"C101","M101",200);
		  Schedule schedule = new Schedule(new Long("101"), date1, date1, airport1, airport2);
		  
		  
		  ScheduledFlight sFlight1= new ScheduledFlight(new Long("101"),120,1000,schedule,flight);
		  assertEquals(b1, sFlight1.getScheduledFlightId());
		  assertEquals(120, sFlight1.getAvailableSeat());
		  assertEquals(flight, sFlight1.getFlight());
		  assertEquals(schedule, sFlight1.getSchedule());
	  }
}
