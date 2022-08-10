package com.fininfo.timesheet.service;

import java.util.List;
import java.util.Optional;

import com.fininfo.timesheet.dto.VacationDto;
import com.fininfo.timesheet.entities.Vacation;


public interface VacationService {
	

	Vacation save(Vacation v);
	void deleteById(Long id);
	Optional<Vacation> findById(Long id);
	void Update(Long id, Vacation Vacation);
	List <Vacation> findAll();
	VacationDto convertEntityTODto(Vacation vacation );
	Vacation convetDtoToEntity(VacationDto vacationDto);
}
	