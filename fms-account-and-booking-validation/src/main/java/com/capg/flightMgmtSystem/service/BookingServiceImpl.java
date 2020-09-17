package com.capg.flightMgmtSystem.service;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.capg.flightMgmtSystem.entities.Booking;
import com.capg.flightMgmtSystem.entities.Passenger;
import com.capg.flightMgmtSystem.entities.User;
import com.capg.flightMgmtSystem.repositories.BookingRepository;
import com.capg.flightMgmtSystem.repositories.PassengerRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;
		
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	EmailSenderService emailSenderService;
	
	@Override
	public Booking addBooking(Booking booking) throws MessagingException {
		bookingRepository.save(booking);
		validateBooking(booking);
		return booking;
	}
	
	@Override
	public void validateBooking(Booking booking) throws MessagingException {
		User user = booking.getUser();
		MimeMessage mailMessage = emailSenderService.createMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true);
	    
	    helper.setTo(user.getEmail());
	    helper.setSubject("Booking Confirmation!");
	    helper.setFrom("dsonaje6@gmail.com");
	    helper.setText("<html><body style='border-style: solid;\r\n" + 
	    		"  border-color: #DCDCDC; background-color: #F0FFFF; height: 250px; width:500px; margin-left:250px'>"
	    		+ "<h1>Thanks for registration!</h1><br>" +
	    		booking+"<br><button type='submit' autofocus style='margin-left:220px; border-radius: 9px; border: 2px solid #DCDCDC'>"
	    		+"<a href="+">Confirm Booking</a></button>",true);

	    emailSenderService.sendEmail(mailMessage);
	    validatePassenger(booking);
	}
	
	@Override
	public void validatePassenger(Booking booking) throws MessagingException {
		List<Passenger> pass = booking.getPassengerList();
		passengerRepository.saveAll(pass);
	}
	
	@Override
	public Booking viewBooking(Long bookingId) {
		Booking booking = bookingRepository.findById(bookingId).get();
		return booking;
	}

	@Override
	public List<Booking> viewBooking() {
		List<Booking>bookings = bookingRepository.findAll();
		return bookings;
	}

}
