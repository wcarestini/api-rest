package com.crud.demo.emailsender;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class SendMail {
	
	public void sendTo(String emailDestinatario) {
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("js511706@gmail.com","silv@123"));
			email.setSSLOnConnect(true);
			
			email.setFrom("js511706@gmail.com");
			email.setSubject("Confirmação de cadastro");
			email.setMsg("Cadastro efetuado com sucesso!");
			email.addTo(emailDestinatario);
			email.send();
			
		} catch (EmailException e) {
			e.printStackTrace();
		}		
	}
	
}
