package com.KafkaUserService.api.Kafka;

import com.KafkaUserService.api.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.KafkaUserService.api.models.User;

@Component
public class UserConsumer {

    @Autowired
    EmailService emailService;

    //aqui é o consumer, que le essa mensagem do quadro, que é quando o user é criado
    @KafkaListener(topics = "user-criado", groupId = "grupo-email")
    //esse topico seria como o titulo do "PostIt"
    //e esse groupId seria como o sub-titulo
    public void consumir(User user) {
        System.out.println("Usuário criado! Enviando e-mail para: " + user.getEmail());
        emailService.enviarEmailConfirmacao(user.getEmail(), user.getName());
    }
}
