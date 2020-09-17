package com.capg.flightMgmtSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.flightMgmtSystem.entities.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long>{

}
