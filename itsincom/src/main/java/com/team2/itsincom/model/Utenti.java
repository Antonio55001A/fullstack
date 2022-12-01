package com.team2.itsincom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.data.relational.core.mapping.Column;

@Entity
@Table(name = "utenti")
public class Utenti {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer idutente;
	
	@Size(min=2, max=30)
	public String nome;
	
	@Size(min=2, max=30)
	public String cognome;


	@Size(min=4, max=200)
	public String email;
	
	@Size(min=4 , max=50)
	public String password;

	public Utenti(Integer idutente, 
			@Size(min=2, max=30) String nome,@Size(min=2, max=30) String cognome,
			@Size(min = 4, max = 200) String email,
			@Size(min = 4, max = 50) String password) {
		super();
		this.idutente = idutente;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
	}
	
	public Utenti() {
		
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

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCognome() {
		return cognome;
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
