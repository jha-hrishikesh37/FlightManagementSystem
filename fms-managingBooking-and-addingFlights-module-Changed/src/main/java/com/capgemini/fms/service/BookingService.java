package com.capgemini.fms.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capgemini.fms.entities.Booking;

public interface BookingService {
	
	Booking addBooking(Booking booking);
	public ResponseEntity<?> updateBooking(Booking newBooking);
	public ResponseEntity<?> deleteBooking(Long bookingId);
	public Iterable<Booking> displayAllBooking();
	public ResponseEntity<?> findBookingById(Long bookingId);
	void validateBooking(Booking booking);
	void validatePassenger(Booking booking);
}
