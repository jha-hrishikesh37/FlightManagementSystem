package com.capg.flightMgmtSystem.service;

import java.sql.Date;
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
import org.springframework.transaction.annotation.Transactional;

import com.capg.flightMgmtSystem.entities.Booking;
import com.capg.flightMgmtSystem.entities.BookingDetails;
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
	@Transactional
	public Booking addBooking(BookingDetails booking) throws MessagingException, InsufficientSeatsException {
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
		Booking book=new Booking();
		
		java.util.Date javaDate= new java.util.Date();
		book.setBookingDate(new Date(javaDate.getTime()));
		
	
		book.setTicketCost(booking.getScheduledFlight().getTicketCost()*booking.getPassenger().getNumberOfPassengers());
		book.setPassenger(booking.getPassenger());
		book.setScheduledFlight(booking.getScheduledFlight());
		book.setUser(booking.getUser());
		
		validateBooking(book);
		
		return book;
		}
	}
	
	/*************************************** Validate Booking **************************************/
	
	@Override
	public void validateBooking(Booking booking) throws MessagingException, InsufficientSeatsException {
		logger.info("Validate Booking");
	
		int passNo = booking.getPassenger().getNumberOfPassengers();
		int avSeat = booking.getScheduledFlight().getAvailableSeat();
		ScheduledFlight sFlight = booking.getScheduledFlight();
		
			avSeat-=passNo;
			sFlight.setAvailableSeat(avSeat);
			logger.info("Hey"+booking.getUser().getUserName()+booking.getUser().getPassword());
			booking=bookingRepository.save(booking);
			logger.info("Hello"+booking);
		User user = booking.getUser();
		MimeMessage mailMessage = emailSenderService.createMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true);
	    
	    helper.setTo(user.getEmail());
	    helper.setSubject("Booking Confirmation!");
	    helper.setFrom("dsonaje6@gmail.com");

	    helper.setText(emailSenderService.getS1()+booking+emailSenderService.getS2(), true);
	    emailSenderService.sendEmail(mailMessage);
	    
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

