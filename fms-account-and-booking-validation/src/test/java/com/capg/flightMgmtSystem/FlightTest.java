package com.capg.flightMgmtSystem;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.capg.flightMgmtSystem.entities.Flight;
import com.capg.flightMgmtSystem.service.FlightServiceImpl;

class FlightTest {

	Long flightId=Long.valueOf(1L);
	
	@Autowired
	FlightServiceImpl flightService;
		
	 @Test()
	  public final void testEquals() throws NullPointerException {
		  Flight f1=new Flight();
		  assertNotNull(f1);
		  Flight f2=null;
		  Flight f3= new Flight(flightId,"AirIndia","AUI89",200);
		  Flight f4= new Flight(flightId,"AirIndia","AUI89",200);
		  assertTrue(f3.equals(f4));
		  assertFalse(f3.equals(f2));
	 }
	@Test()
	public void testFlight()
	{
		Flight flight=new Flight(flightId,"AirIndia","A1111",200);
		assertEquals(flightId,flight.getFlightNumber());
		assertEquals("AirIndia",flight.getCarrierName());
		assertEquals("A1111",flight.getFlightModel());
		assertEquals(200,flight.getSeatCapacity());
	}
	@Test
	  public final void testToString() {
		  Flight f1= new Flight(flightId,"AirIndia","A1111",200);
		  String result = String.format("flightNumber= " + f1.getFlightNumber() + ", carrierName= " + f1.getCarrierName() + ", flightModel= " + f1.getFlightModel()
					+ ", seatCapacity= " + f1.getSeatCapacity()+"\n",
				  f1.getFlightNumber(),f1.getCarrierName(), f1.getFlightModel(), f1.getSeatCapacity());
		  System.out.println(result);
		  System.out.println(f1.toString());
		  assertEquals(result, f1.toString());
	  }

}

