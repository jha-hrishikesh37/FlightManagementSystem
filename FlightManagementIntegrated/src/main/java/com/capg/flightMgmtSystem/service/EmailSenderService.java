package com.capg.flightMgmtSystem.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.Data;

@Service("emailSenderService")
@Data
public class EmailSenderService {
	
	private JavaMailSender javaMailSender;
	
	@Autowired
	public EmailSenderService(JavaMailSender javaMailSender) {
		this.javaMailSender=javaMailSender;
	}
	
	@Async
	public void sendEmail(MimeMessage email) {
		javaMailSender.send(email);
	}

	public MimeMessage createMessage() {
		
		return javaMailSender.createMimeMessage();
	}

	@Async
	public void sendEmail(SimpleMailMessage email) {
		javaMailSender.send(email);
	}
	
	public void emailFormats1(Object obj) {}
		
	String s1=	"<html><body style='border-style: solid;\r\n border-color: #DCDCDC; background-color: #F0FFFF; height: 350px; width:500px; margin-left:250px'>"
			+ "<h1>Thanks for Booking!</h1><br>" ;

	String s2="<br><button type='submit' autofocus style='margin-left:220px;border-radius: 9px; border: 2px solid #DCDCDC'><a>Confirm Booking</a></button>";
	
}
