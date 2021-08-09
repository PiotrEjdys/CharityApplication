package pl.coderslab.charity.email.service;

public interface EmailService {
   void sendSimpleMessage(String to, String subject, String text);
}
