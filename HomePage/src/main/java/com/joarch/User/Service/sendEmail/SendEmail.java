package com.joarch.User.Service.sendEmail;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	
	private String userEmail;
	private String myHas;
	public SendEmail(String userEmail, String myHas) {
		//super();
		this.userEmail = userEmail;
		this.myHas = myHas;
	}
	
	public void sendmail() {
		final String email = "yojan.gautam0@gmail.com";
		final String password ="Yojan@123";
		
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props,new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password);
			}
		});
		
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));
			message.setSubject("Verification Email");
			message.setText("Your Verification link::" +"http://localhost:8080/HomePage/ActivateAccount?key1="+userEmail+"&key2="+myHas);
			Transport.send(message);
		} catch (Exception e) {
			System.out.println("Sending Email " + e);
		}
		
	
	}

}
