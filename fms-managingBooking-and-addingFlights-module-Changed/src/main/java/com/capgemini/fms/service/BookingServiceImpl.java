package com.capgemini.fms.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.fms.entities.Booking;
import com.capgemini.fms.exceptions.RecordNotFoundException;
import com.capgemini.fms.repositories.BookingRepository;
import com.capgemini.fms.repositories.PassengerRepository;


@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	/**
	   * This method is used to update the bookings in the database. 
	   * @param changedBooking       :This is the parameter of type Booking
	   * @return ResponseEntity : This returns OK status code, else throws an exception
	   */
	@Override
	public ResponseEntity<?> updateBooking(Booking changedBooking) {//
		Optional<Booking> findBookingById = bookingRepository.findById(changedBooking.getBookingId());
		try {
			if (findBookingById.isPresent()) {
				bookingRepository.save(changedBooking);
				return new ResponseEntity<Booking>(HttpStatus.OK);
			} else
				throw new RecordNotFoundException("Booking with Booking Id: " + changedBooking.getBookingId() + " not exists!!");
		} catch (RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	/**
	   * This method is used to delete the bookings from the database. 
	   * @param bookingId       :This is the parameter of type BigInteger
	   * @return ResponseEntity : This returns OK status code, else throws an exception
	   */
	@Override
	public ResponseEntity<?> deleteBooking(Long bookingId) {//
		Optional<Booking> findBookingById = bookingRepository.findById(bookingId);
		try {
			if (findBookingById.isPresent()) {
				bookingRepository.deleteById(bookingId);
				return new ResponseEntity<Booking>(HttpStatus.OK);
			} else
				throw new RecordNotFoundException("Booking not found for the entered BookingID");
		} catch (RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	   * This method is used to read all the bookings from the database. 
	  * @return Iterable<Booking> : This returns all the bookings present in database
	   */
	@Override
	public Iterable<Booking> displayAllBooking() {//date and flight no

		return bookingRepository.findAll();
	}

	/**
	   * This method is used to find the bookings using their ID. 
	   * @param bookingId      :This is the parameter of type BigInteger
	   * @return ResponseEntity : This returns OK status code along with Booking object, else throws an exception
	   */
	@Override
	public ResponseEntity<?> findBookingById(Long bookingId) {
		Optional<Booking> findById = bookingRepository.findById(bookingId);
		try {
			if (findById.isPresent()) {
				Booking findBooking = findById.get();
				return new ResponseEntity<Booking>(findBooking, HttpStatus.OK);
			} else
				throw new RecordNotFoundException("No record found with ID " + bookingId);
		} catch (RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@Override
	public Booking addBooking(Booking booking) {
		return null;
	}
	
	@Override
	public void validateBooking(Booking booking) {
		
	}
	
	@Override
	public void validatePassenger(Booking booking) {

	}

}

