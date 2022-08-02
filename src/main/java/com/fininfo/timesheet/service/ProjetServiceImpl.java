package com.fininfo.timesheet.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fininfo.timesheet.Dto.ProjetDto;
import com.fininfo.timesheet.entites.Projet;
import com.fininfo.timesheet.repos.ProjetRepository;


@Service 
public class ProjetServiceImpl implements ProjetService{
	private ModelMapper modelMapper;
	 @Autowired
	   ProjetRepository projetRepository;
		@Override
		public Projet saveProjet(Projet p) {
			return projetRepository.save(p);
		}

		@Override
		public Projet updateProjet(Projet p) {
			return projetRepository.save(p);
		}

		@Override
		public void deleteProjet(Projet p) {
			 projetRepository.delete(p);
			
		}

		@Override
		public void deleteProjetById(Long id) {
			 projetRepository.deleteById(id);
			
		}

		@Override
		public Projet getProjet(Long id) {
			return projetRepository.findById(id).get();
		}

		@Override
		public List<Projet> getAllProjets() {
			return projetRepository.findAll();
		}

		@Override
		public ProjetDto convertEntityTODto(Projet projet) {
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
			ProjetDto projetDto = new ProjetDto();
			projetDto = modelMapper.map(projet,ProjetDto.class);
			return projetDto;	
		}

		@Override
		public Projet convetDtoToEntity(ProjetDto projetDto) {
			 modelMapper.getConfiguration()
	         .setMatchingStrategy(MatchingStrategies.LOOSE);
	 Projet projet = new Projet();
        projet = modelMapper.map(projetDto, Projet.class);
	 return projet;
		}

		
		
}
