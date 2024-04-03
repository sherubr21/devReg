package com.Athang.Athang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service

public class SmtpGmailSenderService {
    @Autowired
     JavaMailSender emailSender;

    public void sendEmail(String toEmail, String subject, String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("your-sender-email@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);

        emailSender.send(message);

        System.out.println("Message sent successfully");
    }
}
