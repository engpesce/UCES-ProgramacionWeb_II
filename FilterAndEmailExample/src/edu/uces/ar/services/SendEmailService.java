package edu.uces.ar.services;

public interface SendEmailService {

	public boolean sendEmail(String from, String to, String subject, String message);
	
}
