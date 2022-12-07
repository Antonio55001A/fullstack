package com.team2.itsincom.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.team2.itsincom.model.Risposte;

public interface RisposteDao extends CrudRepository <Risposte, Integer>{
	
	Risposte findByIdrisposta(Integer idrisposta);
	List<Risposte> findByVoto(Integer voto);
	
}
