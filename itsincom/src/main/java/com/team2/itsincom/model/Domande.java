package com.team2.itsincom.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "domande")
public class Domande {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer iddomanda;
	
	@ManyToOne
    @JoinColumn(name = "idquestionariAdmin")
	public QuestionariAdmin questionariAdmin;
	
	public String testo="";
	
	public Domande(Integer iddomanda, String testo, QuestionariAdmin questionariAdmin) {
		super();
		this.iddomanda = iddomanda;
		this.questionariAdmin = questionariAdmin;
		this.testo = testo;
	}
	
	public Domande() {}
	
	public Integer getiddomanda() {
		return iddomanda;
	}

	public void setiddomanda(Integer iddomanda) {
		this.iddomanda = iddomanda;
	}

	public String getTesto() {
		return testo;
	}

	public void testo(String testo) {
		this.testo = testo;
	}
	
	public QuestionariAdmin getquestionariAdmin() {
		return questionariAdmin;
	}

	public void setQuestionariAdmin(QuestionariAdmin questionariAdmin) {
		this.questionariAdmin = questionariAdmin;
	}

}
