package com.team2.itsincom.Dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.team2.itsincom.model.Domande;

public interface DomandeDao extends CrudRepository<Domande, Long>{
	
	Domande findByIddomanda(int iddomanda);
	List<Domande> findByTesto(String testo);

}
