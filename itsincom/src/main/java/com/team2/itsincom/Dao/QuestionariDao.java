package com.team2.itsincom.Dao;

<<<<<<< Updated upstream

import org.springframework.data.repository.CrudRepository;

import com.team2.itsincom.model.Domande;
import com.team2.itsincom.model.Questionari;

public interface QuestionariDao extends CrudRepository<Questionari, Long>{
	
	


=======
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.team2.itsincom.model.Questionari;

public interface QuestionariDao extends CrudRepository <Questionari, Integer>{
	
	Questionari findByIdquestionario (int idquestionario);
	List<ZonedDateTime> findByData (ZonedDateTime data);
	
	//@Query("SELECT * FROM questionari WHERE idutente=:idutente")
	//public List <Questionari> questionariUtente(Integer idutente);
>>>>>>> Stashed changes
}
