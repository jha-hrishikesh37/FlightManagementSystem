package com.capg.flightMgmtSystem.service;

import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.capg.flightMgmtSystem.entities.Booking;
import com.capg.flightMgmtSystem.entities.ScheduledFlight;
import com.capg.flightMgmtSystem.entities.User;
import com.capg.flightMgmtSystem.exceptions.InsufficientSeatsException;
import com.capg.flightMgmtSystem.exceptions.NotFound_EmptyRepoException;
import com.capg.flightMgmtSystem.repositories.BookingRepository;
import com.capg.flightMgmtSystem.repositories.PassengerRepository;
import com.capg.flightMgmtSystem.repositories.ScheduledFlightRepository;

@Service
public class BookingServiceImpl implements BookingService {

	Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	ScheduledFlightRepository scheduleFlightRepository;
		
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	EmailSenderService emailSenderService;
	
	/*************************************** Add Booking **************************************/
	
	@Override
	public Booking addBooking(Booking booking) throws MessagingException, InsufficientSeatsException {
		logger.info("Booking in Service works: ", booking);
		System.out.println(booking);
		int passNo = booking.getNumberOfPassengers();
		int avSeat = booking.getScheduledFlight().getAvailableSeat();
		ScheduledFlight sFlight = booking.getScheduledFlight();
		System.out.println(avSeat);
		if(passNo > avSeat) {
			throw new InsufficientSeatsException("Seats are not available, you can check another flight!!!");
		}
		else {
		
		
		validateBooking(booking);
		
		return booking;
		}
	}
	
	/*************************************** Validate Booking **************************************/
	
	@Override
	public void validateBooking(Booking booking) throws MessagingException, InsufficientSeatsException {
		logger.info("Validate Booking");
	
		int passNo = booking.getNumberOfPassengers();
		int avSeat = booking.getScheduledFlight().getAvailableSeat();
		ScheduledFlight sFlight = booking.getScheduledFlight();
			avSeat-=passNo;
			sFlight.setAvailableSeat(avSeat);
			bookingRepository.save(booking);
		User user = booking.getUser();
		MimeMessage mailMessage = emailSenderService.createMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true);
	    
	    helper.setTo(user.getEmail());
	    helper.setSubject("Booking Confirmation!");
	    helper.setFrom("dsonaje6@gmail.com");
//	    helper.setText("<html><body style='border-style: solid;\r\n" + 
//	    		"  border-color: #DCDCDC; background-color: #F0FFFF; height: 350px; width:500px; margin-left:250px'>"
//	    		+ "<h1>Thanks for Booking!</h1><br>" +
//	    		booking+"<br><button type='submit' autofocus style='margin-left:220px; border-radius: 9px; border: 2px solid #DCDCDC'>"
//	    		+"<a href="+">Confirm Booking</a></button>",true);

	    helper.setText(emailSenderService.getS1()+booking+emailSenderService.getS2(), true);
	    emailSenderService.sendEmail(mailMessage);
	    
	}	   
	
	
	/*************************************** Update Booking **************************************/
	
	@Override
	public ResponseEntity<?> updateBooking(Booking changedBooking) {
		Optional<Booking> findBookingById = bookingRepository.findById(changedBooking.getBookingId());
		try {
			if (findBookingById.isPresent()) {
				bookingRepository.save(changedBooking);
				return new ResponseEntity<Booking>(HttpStatus.OK);
			} else
				throw new NotFound_EmptyRepoException("Booking with Booking Id: " + changedBooking.getBookingId() + " not exists!!");
		} catch (NotFound_EmptyRepoException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	/*************************************** Delete Booking **************************************/
	
	@Override
	public ResponseEntity<?> deleteBooking(Long bookingId) {
		Optional<Booking> findBookingById = bookingRepository.findById(bookingId);
		try {
			if (findBookingById.isPresent()) {
				bookingRepository.deleteById(bookingId);
				return new ResponseEntity<Booking>(HttpStatus.OK);
			} else
				throw new NotFound_EmptyRepoException("Booking not found for the entered BookingID");
		} catch (NotFound_EmptyRepoException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	/*************************************** Display All Booking **************************************/

	@Override
	public Iterable<Booking> displayAllBooking() {

		return bookingRepository.findAll();
	}

	/*************************************** Display Booking By ID **************************************/
	
	@Override
	public ResponseEntity<?> findBookingById(Long bookingId) {
		Optional<Booking> findById = bookingRepository.findById(bookingId);
		try {
			if (findById.isPresent()) {
				Booking findBooking = findById.get();
				return new ResponseEntity<Booking>(findBooking, HttpStatus.OK);
			} else
				throw new NotFound_EmptyRepoException("No record found with ID " + bookingId);
		} catch (NotFound_EmptyRepoException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}

