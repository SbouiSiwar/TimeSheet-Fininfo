package com.fininfo.timesheet.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import org.springframework.web.bind.annotation.RestController;

import com.fininfo.timesheet.entities.Vacation;
import com.fininfo.timesheet.repos.VacationRepository;
import com.fininfo.timesheet.service.VacationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;




@Slf4j
@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/vacations")

public class VacationController {
	
	@Autowired
    VacationService vacationService;



    public VacationController(VacationRepository  vacationRepository) {
    }

	@GetMapping
	 @ResponseBody
	  public List<Vacation> findAll(){
		List<Vacation> list= vacationService.findAll();
		return list;	
	}       

	@GetMapping("/{id}")
	@ResponseBody
	public Optional<Vacation> findById(@PathVariable(value = "id") long idVacation) {
		 Optional<Vacation> v = vacationService.findById(idVacation);
		return v;
	}

	
	
	 @PutMapping("/{id}")
	 @ResponseBody
	 public Optional<Vacation> updateVacation(@PathVariable("id") long idVacation, @RequestBody Vacation Vacation) {
		 vacationService.Update(idVacation, Vacation);
		 Optional<com.fininfo.timesheet.entities.Vacation> v = vacationService.findById(idVacation);
	        return v;
	    }	 
	@DeleteMapping("/{id}")
	 @ResponseBody
	 public void deletevacation(@PathVariable("id")long idVacation) {
		 vacationService.deleteById(idVacation);
		   
	 }
	 @PostMapping
	 @ResponseBody
	 public Vacation create(@RequestBody Vacation v) {
		   return vacationService.save(v);
	 }
	 

}

