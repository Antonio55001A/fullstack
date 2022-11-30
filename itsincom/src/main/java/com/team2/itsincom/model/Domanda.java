package com.team2.itsincom.model;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Domanda")
public class Domanda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer iddomanda;
	
	public String testo="";
	
	public Domanda(Integer iddomanda, String testo) {
		super();
		this.iddomanda = iddomanda;
		this.testo = testo;
		}

	
	public Domanda() {
		
	}
	
	
	public Integer getiddomanda() {
		return iddomanda;
	}

	public void setiddomanda(Integer iddomanda) {
		this.iddomanda = iddomanda;
	}

	public String getTestoDomanda() {
		return testo;
	}

	public void testoDomanda(String token) {
		this.testo = testo;
	}

}
