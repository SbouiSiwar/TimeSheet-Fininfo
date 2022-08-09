package com.fininfo.timesheet.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.fininfo.timesheet.service.ProjetService;
import com.fininfo.timesheet.Dto.ProjetDto;
import com.fininfo.timesheet.entites.Projet;
import com.fininfo.timesheet.repos.ProjetRepository;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ProjetController {
	@Autowired
 ProjetService projetService;


	 

    private final Logger log = LoggerFactory.getLogger(ProjetController.class);
    private ProjetRepository  projetRepository;

    public ProjetController(ProjetRepository  projetRepository) {
        this.projetRepository = projetRepository;
    }
 @GetMapping("/Projets")
  @ResponseBody
  public List<ProjetDto> getAllProjects(){
	List<ProjetDto> list= projetService.getAllProjets();
	return list;	
                             }
 @GetMapping("/Projets/{title}")
 @ResponseBody
 public List<ProjetDto> getProjectByTitle(@PathVariable("title")String title){
	List<ProjetDto> list= projetService.getProjetByTitle(title);
	return list;	
                            }
 
 @GetMapping("/Projet/{id}")
 @ResponseBody
 public ProjetDto getProject(@PathVariable("id")Long id){
	ProjetDto p = projetService.getProjet(id);
	return p;	
 }
 @PostMapping("/AddProjet")
 @ResponseBody
 public Projet AddUser(@RequestBody ProjetDto p) {
	   return projetService.saveProjet(p);
 }
 @DeleteMapping("/deleteProject/{id}")
 @ResponseBody
 public void deleteProjet(@PathVariable("id")Long id) {
	 projetService.deleteProjetById(id);
	   
 }
 @PutMapping("/updateProject/{id}")
 public Projet UpdateUser( @RequestBody ProjetDto p) {
     log.info("Request to update group: {}", p);
     return  projetService.updateProjet(p);
    
 }
}


