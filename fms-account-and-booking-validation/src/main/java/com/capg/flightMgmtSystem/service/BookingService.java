package com.capg.flightMgmtSystem.service;

import javax.mail.MessagingException;

import org.springframework.http.ResponseEntity;

import com.capg.flightMgmtSystem.entities.Booking;
import com.capg.flightMgmtSystem.entities.BookingDetails;
import com.capg.flightMgmtSystem.exceptions.InsufficientSeatsException;

public interface BookingService {
	
	Booking addBooking(BookingDetails booking) throws MessagingException, InsufficientSeatsException;
	void validateBooking(Booking booking) throws MessagingException, InsufficientSeatsException;
	ResponseEntity<?> updateBooking(Booking changedBooking);
	ResponseEntity<?> deleteBooking(Long bookingId);
	Iterable<Booking> displayAllBooking();
	ResponseEntity<?> findBookingById(Long bookingId);
}

