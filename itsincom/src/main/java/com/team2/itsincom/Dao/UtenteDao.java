package com.team2.itsincom.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.team2.itsincom.model.Utente;

public interface UtenteDao extends CrudRepository<Utente, Long>{
	
	Utente findByIdutente(int idutente);
	/*List<Utente> findByEmail(String email);*/
	List<Utente> findByPassword(String password);
	Utente findByEmail(String email);

	
    @Query(value = "select s from Utente s where email= :email and password = :password")
	public Utente login(String email, String password) ;
    
    
}


/*    @Modifying
	@Transactional
	@Query(value = "UPDATE Utente AS u SET u.password=:password WHERE u.email=:email", nativeQuery = true)
	public String updatePassword(@Param("password") String password,@Param("email") String email);
 * 
 * 
 * UPDATE Utente as u SET u.password = 'Juve2003'WHERE u.email = 'antoniodebiase2003@gmail.com';*/
 