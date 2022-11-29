package com.team2.itsincom.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.team2.itsincom.model.Token;
import com.team2.itsincom.model.Usercode;
import com.team2.itsincom.model.Utente;

public interface UsercodeDao extends CrudRepository<Usercode, Long>{
	
	List<Usercode> findBytoken(Token token);



}
