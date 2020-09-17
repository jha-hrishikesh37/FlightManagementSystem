package com.capg.flightMgmtSystem.service;

import java.util.List;

import javax.mail.MessagingException;

import com.capg.flightMgmtSystem.entities.Booking;
import com.capg.flightMgmtSystem.entities.Passenger;

public interface BookingService {
	
	Booking addBooking(Booking booking) throws MessagingException;
	Booking viewBooking(Long bookingId);
	List<Booking> viewBooking();
	void validateBooking(Booking booking) throws MessagingException;
	void validatePassenger(Booking booking) throws MessagingException;
}
