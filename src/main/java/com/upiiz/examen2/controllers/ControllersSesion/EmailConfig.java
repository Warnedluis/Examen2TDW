package com.upiiz.examen2.controllers.ControllersSesion;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration

public class EmailConfig {
    // Aquí puedes configurar los detalles de tu servidor de correo electrónico
    // como el host, puerto, usuario y contraseña.
    @Value("${email.username}")
    private String emailUsername;

    @Value("${password.username}")
    private String emailPassword;

private Properties getMailProperties() {
    Properties properties = new Properties();
    properties.put("mail.smtp.auth", "true");
    
    // Configuración crítica para puerto 465 (SSL)
    properties.put("mail.smtp.ssl.enable", "true"); 
    properties.put("mail.smtp.socketFactory.port", "465");
    properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    properties.put("mail.smtp.socketFactory.fallback", "false");
    
    // IMPORTANTE: Desactiva STARTTLS si usas SSL puro (puerto 465)
    properties.put("mail.smtp.starttls.enable", "false"); 
    
    return properties;
}

    @Bean 
    public JavaMailSenderImpl javaMailSenderImpl()
    {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(465);
        mailSender.setJavaMailProperties(getMailProperties());
        mailSender.setUsername(emailUsername);
        mailSender.setPassword(emailPassword);
        mailSender.setDefaultEncoding("UTF-8");
        return mailSender;
    }

    @Bean
    public ResourceLoader resourceLoader()
    {
        return new DefaultResourceLoader();
    }
}