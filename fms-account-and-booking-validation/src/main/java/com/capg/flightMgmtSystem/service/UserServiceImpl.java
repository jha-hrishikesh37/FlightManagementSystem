package com.capg.flightMgmtSystem.service;

import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.capg.flightMgmtSystem.entities.User;
import com.capg.flightMgmtSystem.exceptions.NotFound_EmptyRepoException;
import com.capg.flightMgmtSystem.exceptions.UserAlreadyExistsException;
import com.capg.flightMgmtSystem.repositories.LoginUserRepository;
import com.capg.flightMgmtSystem.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

org.slf4j.Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	EmailSenderService emailSenderService;
	
	@Autowired
	LoginUserRepository loginUserRepository;
	
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

        helper.setText(emailSenderService.getS1()+user+emailSenderService.getS2(),true);
        emailSenderService.sendEmail(mailMessage);
	}

/***********************************Login User*******************************/
	
	@Override
	public User doLogin(String email, String password) {
		int flag=0;

		Iterable<User> u1 = loginUserRepository.findAll();
		System.out.println(u1);
		
		for(User u:u1) {
			if((email.equals(u.getEmail())) && password.equals(u.getPassword()) ) {
				logger.info("Login Successful!");
				flag = 1;
				return u;
			} 
		}
		return null;
	}

	@Override
	public User findUser(Long userid) throws NotFound_EmptyRepoException {
		User userOptional = loginUserRepository.findById(userid).get();
		if(userOptional!=null) {
			return userOptional;
		}
		else
			throw new NotFound_EmptyRepoException("User Not Found!");
	}
	
}



