package com.team2.itsincom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.data.relational.core.mapping.Column;

@Entity
@Table(name = "Utente")
public class Utente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer idutente;
	

	@Size(min=10, max=200)
	public String email;
	
	@Size(min=4 , max=50)
	public String password;

	public Utente(Integer idutente, @Size(min = 20, max = 200) String email,
			@Size(min = 10, max = 15) String password) {
		super();
		this.idutente = idutente;
		this.email = email;
		this.password = password;
	}
	
	public Utente() {
		
	}



	public Integer getIdutente() {
		return idutente;
	}

	public void setIdutente(Integer idutente) {
		this.idutente = idutente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
