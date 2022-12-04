package com.team2.itsincom.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.team2.itsincom.model.Questionari;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;

public interface QuestionariDao extends CrudRepository <Questionari, Integer>{
	
	Questionari findByIdquestionario (int idquestionario);
	List<ZonedDateTime> findByData (ZonedDateTime data);
	
	@Query(value = "SELECT * FROM questionari WHERE idutente=:idutente", nativeQuery = true)
	public Collection <Questionari> questionariUtente(Integer idutente);
}
