package org.serratec.backend.trabalho.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {
	
    @Autowired
    private JavaMailSender javaMailSender;

    public void enviarEmail(String para, String assunto, String texto) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("mathserratec@gmail.com");
        msg.setTo(para);
        msg.setSubject(assunto);
        msg.setText("Seu cadastro foi realizado/atualizado com sucesso!");
        javaMailSender.send(msg);
    }
}
