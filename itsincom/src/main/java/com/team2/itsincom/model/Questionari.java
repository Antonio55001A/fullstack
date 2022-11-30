package com.team2.itsincom.model;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Questionari")
public class Questionari {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer idquestionario;
	
	
	
	@ManyToOne
    @JoinColumn(name = "idutente")
    public Utente utente;
	
	
	ZonedDateTime date = ZonedDateTime.now();
	
	
	public Questionari(Integer idquestionario,  ZonedDateTime date) {
		super();
		this.idquestionario = idquestionario;
		this.date = date;	
		}
	
	public Integer getidquestionario() {
		return idquestionario;
	}

	public void setidquestionario(Integer idquestionario) {
		this.idquestionario = idquestionario;
	}
	
	public Utente getutente() {
		return utente;
	}

	public void setutente(Utente utente) {
		this.utente = utente;
	}
	
	public ZonedDateTime getdata() {
		return date;
	}

	public void setdata(ZonedDateTime date) {
		this.date = date;
	}

}
