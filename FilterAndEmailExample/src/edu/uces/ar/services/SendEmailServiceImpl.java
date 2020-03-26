package edu.uces.ar.services;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailServiceImpl implements SendEmailService{

	private final static String SMTP_ACCOUNT_SERVER = "smtp.gmail.com";
	private final static String SMTP_ACCOUNT_NAME = "usuario@gmail.com";
	private final static String SMTP_ACCOUNT_PASS = "password";
	
	@Override
	public boolean sendEmail(String from, String to, String subject, String message) {
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.debug", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.localhost", "FilterAndEmailExample");
		  
		Session s = Session.getInstance(props, null);
		s.setDebug(true);
		  
		MimeMessage mimeMessage = new MimeMessage(s);
		
		try {
			InternetAddress fromAddress = new InternetAddress(from, from);
			InternetAddress toAddress = new InternetAddress(to);
			  
			mimeMessage.setSentDate(new Date());
			mimeMessage.setFrom(fromAddress);
			mimeMessage.addRecipient(Message.RecipientType.TO, toAddress);
			  
			mimeMessage.setSubject(subject);
			mimeMessage.setContent(message, "text/plain");
			  
			Transport tr = s.getTransport("smtp");
			tr.connect(SMTP_ACCOUNT_SERVER, SMTP_ACCOUNT_NAME, SMTP_ACCOUNT_PASS);
			mimeMessage.saveChanges();
			tr.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
			tr.close();
			
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage() + ". Causa: " + e.getCause());
		}
		return false;
	}

	
	
}
