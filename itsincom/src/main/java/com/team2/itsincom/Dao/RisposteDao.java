package com.team2.itsincom.Dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.team2.itsincom.model.Risposte;

public interface RisposteDao extends CrudRepository <Risposte, Integer>{
	
	Risposte findByIdrisposta(Integer idrisposta);
	List<Risposte> findByVoto(Integer voto);
	
	@Query(value = "SELECT * FROM risposte WHERE idquestionario=:idquestionario", nativeQuery = true)
	public Collection <Risposte> risposteQuestionarioUtente(Integer idquestionario);
	
	@Query(value = "SELECT AVG(voto) as voto FROM risposte", nativeQuery = true)
	public float calcolaMedia();
	
	@Query(value = "SELECT COUNT(voto) FROM risposte WHERE voto = :numero", nativeQuery = true)
	public int calcolaNumeroRecensori(Integer numero);
	
	
}
