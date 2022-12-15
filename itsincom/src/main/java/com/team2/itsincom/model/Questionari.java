package com.team2.itsincom.model;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "questionari")
public class Questionari {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer idquestionario;
	
	@ManyToOne
    @JoinColumn(name = "idutente")
    public Utenti utente;
	
	@OneToOne
	@JoinColumn(name = "idquestionariAdmin")
	public QuestionariAdmin questionariadmin;
	
	ZonedDateTime data = ZonedDateTime.now();
	
	public Questionari(Utenti utente, QuestionariAdmin questionariadmin, ZonedDateTime data) {
		super();
		this.utente = utente;
		this.questionariadmin = questionariadmin;
		this.data = data;
	}

	public Questionari() {
		super();
	}

	public Questionari(Integer idquestionario, Utenti utente, ZonedDateTime data) {
		super();
		this.idquestionario = idquestionario;
		this.utente = utente;
		this.data = data;
	}

	public Integer getidquestionario() {
		return idquestionario;
	}

	public void setidquestionario(Integer idquestionario) {
		this.idquestionario = idquestionario;
	}
	
	public Utenti getutente() {
		return utente;
	}

	public void setutente(Utenti utente) {
		this.utente = utente;
	}
	
	public QuestionariAdmin getQuestionariAdmin() {
		return questionariadmin;
	}


	public ZonedDateTime getdata() {
		return data;
	}

	public void setdata(ZonedDateTime data) {
		this.data = data;
	}

}
