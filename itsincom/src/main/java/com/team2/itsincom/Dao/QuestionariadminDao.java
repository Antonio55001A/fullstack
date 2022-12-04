package com.team2.itsincom.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.team2.itsincom.model.Questionariadmin;

public interface QuestionariadminDao extends CrudRepository<Questionariadmin, Integer>{
	
	Questionariadmin findByidquestionariadmin (int idquestionariadmin);
	List<Questionariadmin> findByTitolo(String titolo);
	
}
