package com.example.ninad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendContactInfo(String name, String phone)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("ninadpurkar22@gmail.com");
        message.setSubject("New Contact Details");
        message.setText("Name :" +name +"\nphone: " +phone);
        mailSender.send(message);
    }
}
