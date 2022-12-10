package com.team2.itsincom.Dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.team2.itsincom.model.QuestionariAdmin;

public interface QuestionariAdminDao extends CrudRepository<QuestionariAdmin, Integer>{
	
	QuestionariAdmin findByIdquestionariAdmin (int idquestionariAdmin);
	List<QuestionariAdmin> findByTitolo(String titolo);
	List<QuestionariAdmin> findByStato(boolean stato);
	
	@Query(value = "SELECT * FROM questionariadmin WHERE stato=:stato", nativeQuery = true)
	public Collection <QuestionariAdmin> questionariStato(boolean stato);
	
}
