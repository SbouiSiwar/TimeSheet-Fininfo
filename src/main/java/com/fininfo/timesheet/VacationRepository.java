package com.fininfo.timesheet.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fininfo.timesheet.entities.Vacation;


public interface VacationRepository extends JpaRepository<Vacation, Long> {

}