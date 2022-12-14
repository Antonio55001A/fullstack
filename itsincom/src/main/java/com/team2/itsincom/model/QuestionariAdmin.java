package com.team2.itsincom.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "questionariadmin")
public class QuestionariAdmin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer idquestionariAdmin;
	
	@Size(min=2, max=30)
	public String titolo;
	
	public boolean stato;

	@OneToMany(mappedBy = "questionariAdmin")
	public Set <QuestionariAdmin> questionariAdmin;
	
	public QuestionariAdmin(Integer idquestionariAdmin, @Size(min = 2, max = 30) String titolo, boolean stato) {
		super();
		this.idquestionariAdmin = idquestionariAdmin;
		this.titolo = titolo;
		this.stato = stato;
	}

	public QuestionariAdmin() {}
	
	public Integer getIdquestionariAdmin() {
		return idquestionariAdmin;
	}

	public void setIdquestionariAdmin(Integer idquestionariAdmin) {
		this.idquestionariAdmin = idquestionariAdmin;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public String getTitolo() {
		return titolo;
	}

	public boolean isStato() {
		return stato;
	}

	public void setStato(boolean stato) {
		this.stato = stato;
	}
	
	
	
}
