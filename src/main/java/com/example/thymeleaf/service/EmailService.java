package com.example.thymeleaf.service;

import javax.mail.MessagingException;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailService {
	
	private final TemplateEngine templateEngine;

    private final JavaMailSender javaMailSender;

    public EmailService(TemplateEngine templateEngine, JavaMailSender javaMailSender) {
        this.templateEngine = templateEngine;
        this.javaMailSender = javaMailSender;
    }
    
    public String sendMail(String name, String emailId) throws MessagingException {
        Context context = new Context();
       // context.setVariable("patient", patient);
        
        String process = templateEngine.process("/thymeleafTemplate", context);
        javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setSubject("Welcome " + name);
        helper.setText(process, true);
        helper.setTo(emailId); 
        javaMailSender.send(mimeMessage);
        return "Sent";
    }   
    
}
