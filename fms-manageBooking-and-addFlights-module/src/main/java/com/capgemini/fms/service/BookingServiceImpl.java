package com.capgemini.fms.service;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.fms.dao.BookingDao;
import com.capgemini.fms.entities.Booking;
import com.capgemini.fms.exceptions.RecordNotFoundException;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingDao bookingDao;

	@Override
	public ResponseEntity<?> updateBooking(Booking changedBooking) {
		Optional<Booking> findBookingById = bookingDao.findById(changedBooking.getBookingId());
		try {
			if (findBookingById.isPresent()) {
				bookingDao.save(changedBooking);
				return new ResponseEntity<Booking>(HttpStatus.OK);
			} else
				throw new RecordNotFoundException("Booking with Booking Id: " + changedBooking.getBookingId() + " not exists!!");
		} catch (RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<?> deleteBooking(BigInteger bookingId) {
		Optional<Booking> findBookingById = bookingDao.findById(bookingId);
		try {
			if (findBookingById.isPresent()) {
				bookingDao.deleteById(bookingId);
				return new ResponseEntity<Booking>(HttpStatus.OK);
			} else
				throw new RecordNotFoundException("Booking not found for the entered BookingID");
		} catch (RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Iterable<Booking> displayAllBooking() {

		return bookingDao.findAll();
	}


	@Override
	public ResponseEntity<?> findBookingById(BigInteger bookingId) {
		Optional<Booking> findById = bookingDao.findById(bookingId);
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
	public ResponseEntity<?> createBooking(Booking newBooking) {
		// TODO Auto-generated method stub
		return null;
	}
}
