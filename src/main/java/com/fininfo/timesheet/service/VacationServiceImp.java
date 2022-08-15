package com.fininfo.timesheet.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fininfo.timesheet.dto.VacationDto;
import com.fininfo.timesheet.entities.Vacation;
import com.fininfo.timesheet.repos.VacationRepository;


@Service
public class VacationServiceImp implements VacationService {
	 @Autowired
	    private ModelMapper modelMapper;

	@Autowired

	  VacationRepository vacationRepository;

	@Override
	public Vacation save(Vacation
			v) {
		return vacationRepository.save(v);
	}

	@Override
	public void deleteById(Long id) {
		vacationRepository.deleteById(id);
		
	}

	@Override
	public Optional<Vacation> findById(Long id) {
		return vacationRepository.findById(id);
	}
	
	public void Update(Long id, Vacation Vacation) {
        Vacation VacationFromDb = vacationRepository.findById(id).get();
        System.out.println(VacationFromDb.toString());
        VacationFromDb.setStartDate(Vacation.getStartDate());
        VacationFromDb.setEndDate(Vacation.getEndDate());
        VacationFromDb.setStatus(Vacation.getStatus());
        VacationFromDb.setType(Vacation.getType());

        vacationRepository.save(VacationFromDb);}
	@Override
	public List<Vacation> findAll() {
		return vacationRepository.findAll();
	}
	@Override
	public VacationDto convertEntityTODto(Vacation Vacation) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		VacationDto VacationDto = new VacationDto();
		VacationDto = modelMapper.map(Vacation,VacationDto.class);
		return VacationDto;	
	}

	@Override
	public Vacation convetDtoToEntity(VacationDto VacationDto) {
		 modelMapper.getConfiguration()
         .setMatchingStrategy(MatchingStrategies.LOOSE);
 Vacation Vacation = new Vacation();
    Vacation = modelMapper.map(VacationDto, Vacation.class);
 return Vacation;
	}}


