package com.fininfo.timesheet.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.fininfo.timesheet.exception.ResourceNotFoundException;
import com.fininfo.timesheet.repos.ProjetRepository;
import com.fininfo.timesheet.Model.User;
import com.fininfo.timesheet.Repository.UserRepository;
import com.fininfo.timesheet.Services.UserService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ProjetController {
	@Autowired
 ProjetService projetService;

	
	   @Autowired
	  private UserRepository userRepository;
	   
	   @Autowired
		  private UserService userService;
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
 @PostMapping("/projets/{projetId}/users")
 public User addUser(@PathVariable(value = "projetId") Long projetId, @RequestBody Long userId) {
   
	 
	 Projet p = projetRepository.findById(projetId).get();
     
    
     // tag is existed
    
       User _user = userRepository.findById(userId).get();
        
       p.addUser(_user);
       projetRepository.save(p);
       return _user;
    
   

 }
 @GetMapping("/projetsm/{projetId}")
 public Set<User> ProjetMembers(@PathVariable(value = "projetId") Long projetId) {
   
	 
	 Projet p = projetRepository.findById(projetId).get();

     Set<User> list =p.getUsers() ;
     
       return list ;
    
   

 }
 @GetMapping("/projetm/{projetId}")
public Set<User> availableUsers(@PathVariable(value = "projetId") Long projetId) {
	 Projet p = projetRepository.findById(projetId).get();

     Set<User> list =p.getUsers() ;
     
    List<User> u =userService.getAllUsers();

    Set<User> nlist = new HashSet<>();
 
   
    Set<User> symmetricDiff = new HashSet<User>(u);
 
    if(list.isEmpty())
    {
    	 for(User i : u)
    	    {
    	    	 
    	    		 
    		 symmetricDiff.add(i);
    	    	 }
    }
 
    else {
    symmetricDiff.addAll(list);
    Set<User> tmp = new HashSet<User>(u);
    tmp.retainAll(list);
    symmetricDiff.removeAll(tmp);
    return symmetricDiff;
    
    }
    
       return symmetricDiff ;
 }
 @DeleteMapping("/projets/{projetId}/users/{userId}")
 public void deleteUserFromProjet(@PathVariable(value = "projetId") Long projetId, @PathVariable(value = "userId") Long userId) {
   Projet projet = projetRepository.findById(projetId).get();
      
   
   projet.removeUser(userId);
  projetRepository.save(projet);
   
 }
}


