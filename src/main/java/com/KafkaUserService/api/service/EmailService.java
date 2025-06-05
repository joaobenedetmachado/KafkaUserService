package com.KafkaUserService.api.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarEmailConfirmacao(String para, String nomeUsuario) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(para);
            helper.setSubject("Confirme sua conta");
            helper.setText(
                    "<h1>Olá, " + nomeUsuario + "!</h1><p>Confirme sua conta clicando no link abaixo:</p>" +
                            "<a href=\"http://localhost:8080/user/confirm?email=" + para + "\">Confirmar Conta</a>",
                    true
            );

            mailSender.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException("Erro ao enviar e-mail", e);
        }
    }
    }
