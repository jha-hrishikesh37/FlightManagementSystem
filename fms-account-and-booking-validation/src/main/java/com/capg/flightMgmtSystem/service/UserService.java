package com.capg.flightMgmtSystem.service;

import javax.mail.MessagingException;

import com.capg.flightMgmtSystem.entities.User;
import com.capg.flightMgmtSystem.exceptions.UserAlreadyExistsException;

public interface UserService {

	void addUser(User user) throws MessagingException, UserAlreadyExistsException;
	void validateUser(User user) throws MessagingException;
}

