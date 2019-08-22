package com.sb.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private JavaMailSender javaMailSender;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {

        System.out.println("Sending Email from SpringBoot...");

        try {
		
            sendEmail();

        } catch (Exception e) {
            e.printStackTrace();
        } 
        System.out.println("Email Sent, Please check");

    }

    void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("soxo@onemail1.com");

        msg.setSubject("Spring Boot Email Subject");
        msg.setText("Spring Boot Email Body");

        javaMailSender.send(msg);

    }

   }