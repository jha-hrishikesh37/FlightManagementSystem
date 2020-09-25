package com.capg.flightMgmtSystem.repositories;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.capg.flightMgmtSystem.entities.User;

import lombok.Data;

@Data
@EnableTransactionManagement
@Repository
@Transactional
public class UserRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	@PersistenceContext
	EntityManager entityManager;
	
	public User findPassengerById(Long id) {
		User cd=entityManager.find(User.class, id);
		return cd;
	}
	
	public User findPassengerByEmailIgnoreCase(String email)
	{	
		User cd=null;
		try {
			TypedQuery<User> q2 = entityManager
				.createQuery("SELECT cd from User cd where email='"+email+"'",User.class);
			cd = (User)q2.getSingleResult();
		}
		catch(NoResultException nre) { }
		
		return cd;
	}
	
	public void save(User cd) {
		entityManager.persist(cd);
		entityManager.flush();
	}
	
}