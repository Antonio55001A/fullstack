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
	public Integer idquestionariAdmin;
	
	
	@Size(min=2, max=30)
	public String titolo;

	
	public Questionariadmin(Integer idquestionariAdmin,String titolo ) {
		super();
		this.idquestionariAdmin = idquestionariAdmin;
		this.titolo = titolo;
		
		}

	
	public Questionariadmin() {
		
	}
	
	public Integer getidquestionarioadmin() {
		return idquestionariAdmin;
	}

	public void setidquestionarioadmin(Integer idquestionarioadmin) {
		this.idquestionariAdmin = idquestionariAdmin;
	}
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getTitolo() {
		return titolo;
	}
	
}
