package com.team2.itsincom.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.team2.itsincom.model.Token;
import com.team2.itsincom.model.Utente;

public interface TokenDao extends CrudRepository<Token, Long>{
	
	Token findBytoken(String token);


}
