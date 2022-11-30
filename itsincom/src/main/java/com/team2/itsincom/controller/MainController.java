package com.team2.itsincom.controller;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.security.MessageDigest;

import org.hibernate.engine.internal.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.team2.itsincom.Dao.TokenDao;
import com.team2.itsincom.Dao.UsercodeDao;
import com.team2.itsincom.Dao.UtenteDao;
import com.team2.itsincom.model.Utente;
import com.team2.itsincom.model.ReCaptchaResponse;
import com.team2.itsincom.model.Token;
import com.team2.itsincom.model.Usercode;

@Controller
@RequestMapping("")
public class MainController {
	
	// COMMENTO DI PROVA
	
	@Autowired
	private UtenteDao utenteRepository; 
	
	@Autowired
	private TokenDao tokenRepository; 
	
	@Autowired
	private UsercodeDao usercodeRepository; 
	
	@Autowired
	RestTemplate restTemplate;
	
	// REGISTRAZIONE
	@GetMapping("/registrazione") 
	public String registrazione() {
		return "registrazione";
	}
	
	@RequestMapping(value="/registrazione", method=RequestMethod.POST)
	public String postRegistrazione(
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("g-recaptcha-response") String captchaResponse) {	
		
		
		String url = "https://www.google.com/recaptcha/api/siteverify";
		String params = "?secret=6LcmWycjAAAAAL_CPGuBMw7G9MzzVYRjOYGV0joE&response="+captchaResponse;
		
		ReCaptchaResponse reCaptchaResponse = restTemplate.exchange(url+params, HttpMethod.POST,null,ReCaptchaResponse.class).getBody();		
	{
		
		  String encryptedpassword;
		try   
	        {  
	            /* MessageDigest instance for MD5. */  
	            MessageDigest m = MessageDigest.getInstance("MD5");  
	              
	            /* Add plain-text password bytes to digest using MD5 update() method. */  
	            m.update(password.getBytes());  
	              
	            /* Convert the hash value into bytes */   
	            byte[] bytes = m.digest();  
	              
	            /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */  
	            StringBuilder s = new StringBuilder();  
	            for(int i=0; i< bytes.length ;i++)  
	            {  
	                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
	            }  
	              
	            /* Complete hashed password in hexadecimal format */  
	            encryptedpassword = s.toString();  
		        System.out.println("Plain-text password: " + password);  
		        System.out.println("Encrypted password using MD5: " + encryptedpassword); 
		        
		        		     		        
		        if(reCaptchaResponse.isSuccess()) {
					
				
		        /*save user in db */
				Utente nuovoUtente = new Utente(null, email, encryptedpassword);
				utenteRepository.save(nuovoUtente);
				
		        } else {
		        	return "redirect:/registrazione?error";  
		        }
	        }   
	        catch (NoSuchAlgorithmException e)   
	        {  
	            e.printStackTrace();  
	        }
		return "redirect:/login";  
	          
	    } 
	}
	
	
	// LOGIN
	@GetMapping("/login") 
	public String login() {
		return "login";
	}
	

	@RequestMapping(value="/signin", method=RequestMethod.POST)
	
	public String postLogin(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
		
		  String encryptedpassword;
		try   
	        {  
			
			System.out.println(" inizio decripto password");

	            /* MessageDigest instance for MD5. */  
	            MessageDigest m = MessageDigest.getInstance("MD5");  
	              
	            /* Add plain-text password bytes to digest using MD5 update() method. */  
	            m.update(password.getBytes());  
	              
	            /* Convert the hash value into bytes */   
	            byte[] bytes = m.digest();  
	              
	            /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */  
	            StringBuilder s = new StringBuilder();  
	            for(int i=0; i< bytes.length ;i++)  
	            {  
	                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
	            }  
	              
	            /* Complete hashed password in hexadecimal format */  
	            encryptedpassword = s.toString();  
		        System.out.println("Plain-text password: " + password);  
		        System.out.println("Encrypted password using MD5: " + encryptedpassword); 
		        
		        /*save user in db */

				Utente utente = utenteRepository.login(email, encryptedpassword);
				
				String email_verifica = utente.email;
				System.out.println(" email verifica: "+ email_verifica);

				
				
				if(utente != null) {
				session.setAttribute("loggedUtente", utente);
					if(email_verifica.compareTo("antoniodebiase2003@gmail.com")==0){
						System.out.println(" loggato utente");
						return "redirect:/dashboard";
					}else {
		
					System.out.println(" loggato utente");
					return "redirect:/home";
					}			
				}
	        }
		
    catch (NoSuchAlgorithmException e)   
    {  
        e.printStackTrace();  
		return "redirect:/login?error";
    }
		return "redirect:/login?error";


	}
	
	//home
	// passa oggetto studente
	@GetMapping("/home") 
	public ModelAndView Homepage(Model model,HttpSession session) {
		Utente utente = (Utente) session.getAttribute("loggedUtente");
		ModelAndView mav = new ModelAndView();
		ModelAndView mavlogin = new ModelAndView();
		mav.setViewName("home");
		mav.addObject("utente", utente);
		System.out.println(" loggato mav");
		System.out.println(mav);
		
		// utente loggato dati: 
		System.out.println(utente.email);	
		System.out.println(utente.password);
		System.out.println(utente.idutente);

		return mav;
	}
	
	
	// INIZIO CODICE PER PASSWORD DIMENTICATA
	@GetMapping("/forgot") 
	public String forgotPassword() {
		return "forgot";
	}
	
	@GetMapping("/change") 
	public String changePassword() {
		return "change";
	}
	
	
	
	@RequestMapping(value="/changePassword", method=RequestMethod.POST)
	public String postChange(@RequestParam("password") String password,@RequestParam("code") String code, Model model, HttpSession session) {
		
		
		Token codice=tokenRepository.findBytoken(code);
		
		
		System.out.println("verifica codice autenticazione");    	

        if(codice != null) {
    		System.out.println(" codice esistente");
			List<Usercode> usercode = usercodeRepository.findBytoken(codice);
    		System.out.println(" codice esistente anche nei log");
    		System.out.println(usercode);    
    		
    		System.out.println(" verifica codice eseguita - step 1 Fatto-");

    		
    		System.out.println(" Inizio step 2");
    		System.out.println(" Utilizzo metodo get per utente nella session");

    		Utente utente = (Utente) session.getAttribute("utente");
    		System.out.println(utente.idutente);    	
    		
    		System.out.println(" utente trovato, trovato anche id");
    		System.out.println(" inizializzazione id");

    		Integer id= utente.idutente;
    		
    		System.out.println(" ricerca utente tramite id");

    		Utente cliente = utenteRepository.findByIdutente(id);

    		System.out.println(" utente trovato tramite id");

    		if(cliente!=null) {
    			
			System.out.println(" utente trovato");
			
			// da corregere
			
			  String encryptedpassword;
				try   
			        {  
					
					System.out.println(" inizio decripto password");

			            /* MessageDigest instance for MD5. */  
			            MessageDigest m = MessageDigest.getInstance("MD5");  
			              
			            /* Add plain-text password bytes to digest using MD5 update() method. */  
			            m.update(password.getBytes());  
			              
			            /* Convert the hash value into bytes */   
			            byte[] bytes = m.digest();  
			              
			            /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */  
			            StringBuilder s = new StringBuilder();  
			            for(int i=0; i< bytes.length ;i++)  
			            {  
			                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
			            }  
			              
			            /* Complete hashed password in hexadecimal format */  
			            encryptedpassword = s.toString();  
				        System.out.println("Plain-text password: " + password);  
				        System.out.println("Encrypted password using MD5: " + encryptedpassword); 
				        
				        /*save user in db */

				        cliente.setPassword(encryptedpassword);
				        
						utenteRepository.save(cliente);						
						return "redirect:/login";

						
			        } 
				
		    catch (NoSuchAlgorithmException e)   
		    {  
	        	
	        	// in caso errato, richiede di reinviare l'email 
	    		System.out.println(" codice  non esistente, inserire il codice corretto ");

		    }
			

    		}
    		

        }
		return "redirect:/change";

	}
	
	@RequestMapping(value="/forgotPassword", method=RequestMethod.POST)
	public String postForgot(@RequestParam("email") String email, Model model, HttpSession session) {
				
			//inserimento credenziali account mittente
		
				final String username = "javaemail75@gmail.com"; //email di chi invia
		     final String password = "fsvbgyrecuesbmku"; // password di chi invia

		     
		     // settaggi gmail
		     Properties prop = new Properties();
				prop.put("mail.smtp.host", "smtp.gmail.com");
		     prop.put("mail.smtp.port", "465");
		     prop.put("mail.smtp.auth", "true");
		     prop.put("mail.smtp.socketFactory.port", "465");
		     prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		     
		     
		     //login gmail con credenziali sopra inserite
		     Session session1 = Session.getInstance(prop,
		             new javax.mail.Authenticator() {
		                 protected PasswordAuthentication getPasswordAuthentication() {
		                     return new PasswordAuthentication(username, password);
		                 }
		             });
		     
		        

		     try {
		    	 
		    	 
		    	 // verifica se l'utente esiste all'interno del db
		    	 
			        Utente user = utenteRepository.findByEmail(email);
			        if(user != null) {
			    		System.out.println(" utente esistente");
			        	
			        
			        }else {
			        	
			        	// in caso errato, richiede di reinviare l'email 
			    		System.out.println(" utente  non esistente, riprovare");

			    		return "redirect:/forgot";

			        }		  

			        
					//creazione token
					String chiave = Token.generateNewToken();
					System.out.println(chiave);
					 ZonedDateTime date=ZonedDateTime.now();
					Token token = new Token(null, chiave, date);
					tokenRepository.save(token);
					
					
					
		     	// si logga ed invia email con mittente indicato sopra ed email indicate dopo parse
		         Message message = new MimeMessage(session1);
		         message.setFrom(new InternetAddress(username));
		         message.setRecipients(
		                 Message.RecipientType.TO,
		                 // email destinatarie
		                 InternetAddress.parse(email)
		         );
		         // creazione messaggio 
		         message.setSubject("VERIFICA LA TUA EMAIL");
		         message.setContent(
		                 "<h1>CLICCA SUL BOTTONE ED INSERISCI IL CODICE DI VERIFICA</h1>"
		                 + "<h3> Il codice di sicurezza è  "+ "<h1 style=\"color: red;\">"+chiave+"</h1>",
		                "text/html");

		         Transport.send(message);
		         
		         
		         // invio token con relativa email al db 
		        

		         System.out.println("Done");
				 Usercode usercode = new Usercode(null, token,email,date);
				 usercodeRepository.save(usercode);
				 
		         System.out.println("usercode done");
				 System.out.println(token);
				 
				 
				 
				 // set email
				 //session.setAttribute("email", email);
				 session.setAttribute("utente", user);


		     } catch (MessagingException e) {
		         e.printStackTrace();
		     }
		return "redirect:/change";

	}
	
	// INIZIO CODICE ADMIN
	
	@GetMapping("/dashboard") 
	public String dashbordAdmin(HttpSession session) {
		
		//verifica utente per poter visualizzare la pagina
		Utente utente= (Utente) session.getAttribute("loggedUtente");
		if(utente.email.compareTo("antoniodebiase2003@gmail.com")==0) {
			return "dashboard";
		}
		
		return "redirect:/login";
	}
	

	
}
