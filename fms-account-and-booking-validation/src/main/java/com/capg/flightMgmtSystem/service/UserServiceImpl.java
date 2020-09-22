package com.capg.flightMgmtSystem.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.capg.flightMgmtSystem.entities.User;
import com.capg.flightMgmtSystem.exceptions.UserAlreadyExistsException;
import com.capg.flightMgmtSystem.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

org.slf4j.Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	EmailSenderService emailSenderService;
	
	/*************************************** Register User **************************************/
	
	@Override
	public void addUser(User user) throws MessagingException, UserAlreadyExistsException {
		logger.trace("Add User working...");
		
		User existingUser = userRepository.findPassengerByEmailIgnoreCase(user.getEmail());
		System.out.println(existingUser);
        if(existingUser != null)
        {
        	throw new UserAlreadyExistsException("User exists with this email id!!!");
        }
        else
        {
        	validateUser(user);
        }  
    }

	/*************************************** Validate User **************************************/
	
	@Override
	public void validateUser(User user) throws MessagingException {
		userRepository.save(user);
        logger.info("user");
        
        MimeMessage mailMessage = emailSenderService.createMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true);
        
        helper.setTo(user.getEmail());
        helper.setSubject("Successfully Registered!");
        helper.setFrom("dsonaje6@gmail.com");
        helper.setText("<html><body style='border-style: solid;\r\n" + 
        		"  border-color: #DCDCDC; background-color: #F0FFFF; height: 250px; width:500px; margin-left:250px'>"
        		+ "<h1>Thanks for registration!</h1><br>" +
        		user+"<br><button type='submit' autofocus style='margin-left:220px; border-radius: 9px; border: 2px solid #DCDCDC'>"
        		+"<a href="+">Show Details</a></button>",true);

        emailSenderService.sendEmail(mailMessage);
	}

}

