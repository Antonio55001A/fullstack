package com.team2.itsincom.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.team2.itsincom.model.Tokens;

public interface TokensDao extends CrudRepository<Tokens, Long>{
	
	Tokens findByvalore(String valore);

	List<Tokens> findByvalore(Tokens codice);


}
