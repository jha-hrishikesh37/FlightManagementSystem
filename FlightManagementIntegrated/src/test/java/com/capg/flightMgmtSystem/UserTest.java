package com.capg.flightMgmtSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.capg.flightMgmtSystem.entities.User;

class UserTest {

	/*************************************** Test for Register User **************************************/
	
	@Test
	void registerUsertest() {
		
		User user1 = new User(new Long("1"), "passenger", "Dhanu", "Dhanu@123", new Long("7028807607"), "dhanashreesonaje9011@gmail.com");
		User user2 = new User(new Long("1"), "passenger", "Dhanu", "Dhanu@123", new Long("7028807607"), "dhanashreesonaje9011@gmail.com");
		
		User user3 = new User();
		assertTrue(user1.equals(user2));
		assertFalse(user3.equals(user2));
	}
	
	/*************************************** Test for toString Verification **************************************/
	
	@Test
	void stringUserTest() {
		User user1 = new User(new Long("1"), "passenger", "Dhanu", "Dhanu@123", new Long("7028807607"), "dhanashreesonaje9011@gmail.com");
		String result = String.format("userid=" + user1.getUserid() + ", userName=" + user1.getUserName() + ", "
				+ "password=" + user1.getPassword()
				+ ", phoneNumber=" + user1.getPhoneNumber() + ", email=" + user1.getEmail()+ ", userType=" + user1.getUserType());
		  assertEquals(result, user1.toString());
	}

}