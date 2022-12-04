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
<<<<<<< Updated upstream
	public Integer idquestionariAdmin;
=======
	public Integer idquestionariadmin;
>>>>>>> Stashed changes
	
	
	@Size(min=2, max=30)
	public String titolo;

	
<<<<<<< Updated upstream
	public Questionariadmin(Integer idquestionariAdmin,String titolo ) {
		super();
		this.idquestionariAdmin = idquestionariAdmin;
=======
	public Questionariadmin(Integer idquestionariadmin,String titolo ) {
		super();
		this.idquestionariadmin = idquestionariadmin;
>>>>>>> Stashed changes
		this.titolo = titolo;
		
		}

	
	public Questionariadmin() {
		
	}
	
<<<<<<< Updated upstream
	public Integer getidquestionarioadmin() {
		return idquestionariAdmin;
	}

	public void setidquestionarioadmin(Integer idquestionarioadmin) {
		this.idquestionariAdmin = idquestionariAdmin;
=======
	public Integer getidquestionariadmin() {
		return idquestionariadmin;
	}

	public void setidquestionarioadmin(Integer idquestionariadmin) {
		this.idquestionariadmin = idquestionariadmin;
>>>>>>> Stashed changes
	}
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public String getTitolo() {
		return titolo;
	}
	
}
