package com.fininfo.timesheet.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fininfo.timesheet.entites.Projet;



public interface ProjetRepository extends JpaRepository<Projet, Long> {
	 List<Projet> findByTitre(String titre);

}
