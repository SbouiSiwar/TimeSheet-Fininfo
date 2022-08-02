package com.fininfo.timesheet.service;

import java.util.List;


import com.fininfo.timesheet.Dto.ProjetDto;
import com.fininfo.timesheet.entites.Projet;





public interface ProjetService {
	Projet saveProjet(Projet p);
	Projet updateProjet(Projet p);
void deleteProjet(Projet p);
 void deleteProjetById(Long id);
 Projet getProjet(Long id);
List<Projet> getAllProjets();
ProjetDto convertEntityTODto(Projet projet );
Projet convetDtoToEntity(ProjetDto projetDto);
}
