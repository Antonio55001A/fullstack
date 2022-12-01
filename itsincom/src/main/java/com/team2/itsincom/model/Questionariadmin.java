package com.team2.itsincom.model;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "questionariadmin")
public class Questionariadmin {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer idquestionarioadmin;
	
	
	@Size(min=2, max=30)
	public String titolo;

	
	public Questionariadmin(Integer idquestionarioadmin,String titolo ) {
		super();
		this.idquestionarioadmin = idquestionarioadmin;
		this.titolo = titolo;
		
		}

	
	public Questionariadmin() {
		
	}
	
	public Integer getidquestionarioadmin() {
		return idquestionarioadmin;
	}

	public void setidquestionarioadmin(Integer idquestionarioadmin) {
		this.idquestionarioadmin = idquestionarioadmin;
	}
	
	public void setTitolo(String nome) {
		this.titolo = titolo;
	}
	public String getTitolo() {
		return titolo;
	}
	
}
