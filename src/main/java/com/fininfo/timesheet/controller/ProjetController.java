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
  public List<Projet> getAllUsers(){
	List<Projet> list= projetService.getAllProjets();
	return list;	
                             }
 
 
 @PostMapping("/AddProjet")
 @ResponseBody
 public Projet AddUser(@RequestBody Projet p) {
	   return projetService.saveProjet(p);
 }
 @DeleteMapping("deleteProjetc/{id}")
 @ResponseBody
 public void deleteProjet(@PathVariable("id")Long idProjet) {
	 projetService.deleteProjetById(idProjet);
	   
 }
 @PutMapping("/updateProject/{id}")
 public Projet UpdateUser( @RequestBody Projet p) {
     log.info("Request to update group: {}", p);
     return  projetService.updateProjet(p);
    
 }
}


