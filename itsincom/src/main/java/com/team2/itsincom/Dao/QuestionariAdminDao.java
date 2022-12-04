package com.team2.itsincom.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.team2.itsincom.model.QuestionariAdmin;

public interface QuestionariAdminDao extends CrudRepository<QuestionariAdmin, Integer>{
	
	QuestionariAdmin findByidquestionariadmin (int idquestionariadmin);
	List<QuestionariAdmin> findByTitolo(String titolo);
	
}
