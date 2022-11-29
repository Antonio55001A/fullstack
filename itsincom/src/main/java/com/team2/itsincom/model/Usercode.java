package com.team2.itsincom.model;

import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Usercode")
public class Usercode {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer idusercode;
	
	
	@ManyToOne
    @JoinColumn(name = "id")
    public Token token;


	public String email;


	ZonedDateTime date = ZonedDateTime.now();

	/*@ManyToOne
    @JoinColumn(name = "idutente")
    public Utente utente;
	*/
	public Usercode(Integer idusercode, Token token, String email, ZonedDateTime date) {
		
		this.idusercode = idusercode;
		this.token = token;
		this.email = email;
		this.date = date;


		//this.utente = utente;


	}

	public Usercode() {
		super();
	}
	
	public Integer getIdusercode() {
		return idusercode;
	}

	public void setIdusercode(Integer idusercode) {
		this.idusercode = idusercode;
	}
	public Token getoken() {
		return token;
	}

	public void setoken(Token token) {
		this.token = token;
	}
	
	/*public Utente getutente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}*/
	
}
