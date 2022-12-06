package com.team2.itsincom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "risposte")
public class Risposte {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer idrisposta;
	
	
	@OneToOne
    @JoinColumn(name = "iddomanda")
    public Domande domanda;
	
	@ManyToOne
    @JoinColumn(name = "idquestionario")
    public Questionari questionario;
	
	public Integer voto = 0;
	
	public Risposte(Integer idrisposta, Domande domanda, Questionari questionario, Integer voto) {
		super();
		this.idrisposta = idrisposta;
		this.domanda = domanda;
		this.questionario = questionario;
		this.voto = voto;
	}

	public Risposte(Domande domanda, Questionari questionario, Integer voto) {
		super();
		this.domanda = domanda;
		this.questionario = questionario;
		this.voto = voto;
	}

	public Risposte(Integer idrisposta, Integer voto) {
		
		this.idrisposta = idrisposta;
		this.voto = voto;
	}

	public Risposte() {
		super();
	}
	
	
	public Integer getidrisposta() {
		return idrisposta;
	}

	public void setidrisposta(Integer idrisposta) {
		this.idrisposta = idrisposta;
	}
	
	public Integer getvoto() {
		return voto;
	}

	public void setvoto(Integer voto) {
		this.voto = voto;
	}

	public Domande getdomanda() {
		return domanda;
	}

	public void setdomanda(Domande domanda) {
		this.domanda = domanda;
	}

	public Questionari getquestionario() {
		return questionario;
	}

	public void setquestionario(Questionari questionario) {
		this.questionario = questionario;
	}
	
}
