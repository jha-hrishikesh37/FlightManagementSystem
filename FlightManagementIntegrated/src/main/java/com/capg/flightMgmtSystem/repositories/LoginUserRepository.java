package com.capg.flightMgmtSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.flightMgmtSystem.entities.User;

@Repository
public interface LoginUserRepository extends JpaRepository<User, Long> {

}
