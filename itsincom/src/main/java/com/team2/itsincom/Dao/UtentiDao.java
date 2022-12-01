package com.team2.itsincom.Dao;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.team2.itsincom.model.Utenti;

public interface UtentiDao extends CrudRepository<Utenti, Long>{
	
	Utenti findByIdutente(int idutente);
	/*List<Utente> findByEmail(String email);*/
	List<Utenti> findByPassword(String password);
	Utenti findByEmail(String email);

	
    @Query(value = "select s from Utenti s where email= :email and password = :password")
	public Utenti login(@Param("email")String email,@Param("password") String password) ;
    
    
}


/*    @Modifying
	@Transactional
	@Query(value = "UPDATE Utente AS u SET u.password=:password WHERE u.email=:email", nativeQuery = true)
	public String updatePassword(@Param("password") String password,@Param("email") String email);
 * 
 * 
 * UPDATE Utente as u SET u.password = 'Juve2003'WHERE u.email = 'antoniodebiase2003@gmail.com';*/
 