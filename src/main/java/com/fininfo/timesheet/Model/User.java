package com.fininfo.timesheet.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fininfo.timesheet.entites.Projet;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "Users")
 @Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email")
    private String email;

    @Column(name = "mot_de_passe")
    private String mot_de_passe;

    @Column(name = "num_tel")
    private int num_tel;

    @Column(name = "solde")
    private int solde;

    @Enumerated(EnumType.STRING)
    private Role roles;

    @ManyToMany(fetch = FetchType.LAZY,
    	      cascade = {
    	          CascadeType.PERSIST,
    	          CascadeType.MERGE
    	      },
    	      mappedBy = "users")
    	  @JsonIgnore
    	  @EqualsAndHashCode.Exclude // <<<<<<<<<<
    	  @ToString.Exclude
    	  private Set<Projet> projets=new HashSet<>();
    public Set<Projet> getProjets() {
        return projets;
      }
      public void setProjets(Set<Projet> projets) {
        this.projets = projets;
        
      }
	public User(String nom, String prenom, String email, String mot_de_passe, int num_tel, int solde, Role roles) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mot_de_passe = mot_de_passe;
		this.num_tel = num_tel;
		this.solde = solde;
		this.roles = roles;
	}
	public User(String nom, String prenom, String email, String mot_de_passe, int num_tel, int solde) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mot_de_passe = mot_de_passe;
		this.num_tel = num_tel;
		this.solde = solde;
	}  
      
}
