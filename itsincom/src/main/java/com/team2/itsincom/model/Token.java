package com.team2.itsincom.model;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Token")
public class Token {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer id;
	
	public String token;
	
	ZonedDateTime date = ZonedDateTime.now();


	
	private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
	private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe

	public Token(Integer id, String token, ZonedDateTime date2) {
		super();
		this.id = id;
		this.token = token;
		this.date = date2;	
		}

	
	public Token() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setIdutente(Integer idutente) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void Token(String token) {
		this.token = token;
	}

	public ZonedDateTime getdata() {
		return date;
	}

	public void setdata(ZonedDateTime date) {
		this.date = date;
	}
	
	public static String generateNewToken() {
	    byte[] randomBytes = new byte[8];
	    secureRandom.nextBytes(randomBytes);
	    return base64Encoder.encodeToString(randomBytes);
	}

}
