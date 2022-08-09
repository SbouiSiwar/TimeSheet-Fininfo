package com.fininfo.timesheet.service;

import java.util.List;


import com.fininfo.timesheet.Dto.ProjetDto;
import com.fininfo.timesheet.entites.Projet;





public interface ProjetService {
	Projet saveProjet(ProjetDto p);
	Projet updateProjet(ProjetDto p);
void deleteProjet(ProjetDto p);
 void deleteProjetById(Long id);
 ProjetDto getProjet(Long id);
 List<ProjetDto> getProjetByTitle(String title);
List<ProjetDto> getAllProjets();
ProjetDto convertEntityTODto(Projet projet );
Projet convetDtoToEntity(ProjetDto projetDto);
List<ProjetDto> convertListEntityTODto(List<Projet> list );
List<Projet> convertListDtoTOEntity(List<ProjetDto> list );
}
