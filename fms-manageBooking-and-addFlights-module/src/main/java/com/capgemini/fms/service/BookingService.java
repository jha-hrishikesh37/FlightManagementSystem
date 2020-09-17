package com.capgemini.fms.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.capgemini.fms.entities.Booking;


public interface BookingService {

	public ResponseEntity<?> createBooking(Booking newBooking);

	public ResponseEntity<?> updateBooking(Booking newBooking);

	public ResponseEntity<?> deleteBooking(BigInteger bookingId);

	public Iterable<Booking> displayAllBooking();

	public ResponseEntity<?> findBookingById(BigInteger bookingId);
}
