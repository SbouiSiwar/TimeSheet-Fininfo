package com.fininfo.timesheet.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fininfo.timesheet.entites.Projet;



public interface ProjetRepository extends JpaRepository<Projet, Long> {

}
