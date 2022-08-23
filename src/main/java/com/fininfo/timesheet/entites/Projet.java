package com.fininfo.timesheet.entites;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fininfo.timesheet.Model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
@Data

@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity

public class Projet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titre,descreption;
	private Date dateDebut,dateFin;

	 @ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		              CascadeType.PERSIST,
		              CascadeType.MERGE
		          })
		      @JoinTable(name = "projet_users",
		            joinColumns = { @JoinColumn(name = "projet_id") },
		            inverseJoinColumns = { @JoinColumn(name = "user_id") })
	 @EqualsAndHashCode.Exclude // <<<<<<<<<<
	 @ToString.Exclude
	  private Set<User> users = new HashSet<>();

	 
	 
	 
	 
	 public void addUser(User u) {
		    this.users.add(u);
		    u.getProjets().add(this);
		  }
		  
		  public void removeUser(long userId) {
		    User user = this.users.stream().filter(u -> u.getId() == userId).findFirst().orElse(null);
		    if (user != null) {
		      this.users.remove(user);
		      user.getProjets().remove(this);
		    }
		  }

		public Projet(String titre, String descreption, Date dateDebut, Date dateFin) {
			super();
			this.titre = titre;
			this.descreption = descreption;
			this.dateDebut = dateDebut;
			this.dateFin = dateFin;
		}
		  
}
