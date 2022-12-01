package com.team2.itsincom.model;

import java.security.SecureRandom;
import java.time.ZonedDateTime;
import java.util.Base64;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tokens")
public class Tokens {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer idtoken;
	
	@ManyToOne
    @JoinColumn(name = "idutente")
    public Utenti utente;
	
	public String valore;
	
	ZonedDateTime data = ZonedDateTime.now();


	
	private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
	private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe

	public Tokens(Integer idtoken, Utenti utente, String valore, ZonedDateTime data) {
		super();
		this.idtoken = idtoken;
		this.utente = utente;
		this.valore = valore;
		this.data = data;	
		}

	
	public Tokens() {
		
	}

	public Integer getidtoken() {
		return idtoken;
	}

	public void setidtoken(Integer idtoken) {
		this.idtoken = idtoken;
	}

	public String getvalore() {
		return valore;
	}

	public void valore(String valore) {
		this.valore = valore;
	}

	public ZonedDateTime getdata() {
		return data;
	}

	public void setdata(ZonedDateTime date) {
		this.data = date;
	}
	
	public Utenti getutente() {
		return utente;
	}

	public void setutente(Utenti utente) {
		this.utente = utente;
	}
	
	public static String generateNewToken() {
	    byte[] randomBytes = new byte[8];
	    secureRandom.nextBytes(randomBytes);
	    return base64Encoder.encodeToString(randomBytes);
	}

}
