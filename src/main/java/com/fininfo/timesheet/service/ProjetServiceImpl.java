package com.fininfo.timesheet.service;


import java.util.ArrayList;
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
	 @Autowired
	private ModelMapper modelMapper;
	 @Autowired
	   ProjetRepository projetRepository;
		@Override
		public Projet saveProjet(ProjetDto p) {
			
			return projetRepository.save(convetDtoToEntity(p));
		}

		@Override
		public Projet updateProjet(ProjetDto p) {
			return projetRepository.save(convetDtoToEntity(p));
		}

		@Override
		public void deleteProjet(ProjetDto p) {
			 projetRepository.delete(convetDtoToEntity(p));
			
		}

		@Override
		public void deleteProjetById(Long id) {
			 projetRepository.deleteById(id);
			
		}

		@Override
		public ProjetDto getProjet(Long id) {
			return convertEntityTODto(projetRepository.findById(id).get());
		}

		@Override
		public List<ProjetDto> getAllProjets() {
			  return convertListEntityTODto(projetRepository.findAll());
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

		@Override
		public List<ProjetDto> getProjetByTitle(String title) {
			return convertListEntityTODto(projetRepository.findByTitre(title));
		}

		@Override
		public List<ProjetDto> convertListEntityTODto(List<Projet> list) {
			 modelMapper.getConfiguration()
	         .setMatchingStrategy(MatchingStrategies.LOOSE);
			 List<ProjetDto> newProjetDtoList = new ArrayList<>();
			 for (Projet p : list) {
				 ProjetDto projetDto = new ProjetDto();
					projetDto = modelMapper.map(p,ProjetDto.class); 
					newProjetDtoList.add(projetDto);
			    }
	
	 return newProjetDtoList;
		}

		@Override
		public List<Projet> convertListDtoTOEntity(List<ProjetDto> list) {
			 modelMapper.getConfiguration()
	         .setMatchingStrategy(MatchingStrategies.LOOSE);
			 List<Projet> newProjetList = new ArrayList<>();
			 for (ProjetDto pDto : list) {
				 Projet projet = new Projet();
					projet = modelMapper.map(pDto,Projet.class); 
					newProjetList.add(projet);
			    }
	
	 return newProjetList;
		}

	
		
		
}
