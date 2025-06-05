package com.KafkaUserService.api.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.KafkaUserService.api.models.User;

@Component
public class UserConsumer {

    @KafkaListener(topics = "user-criado", groupId = "grupo-email")
    public void consumir(User user) {
        System.out.println("Usuário criado! Enviando e-mail para: " + user.getEmail());
        // aqui você chamaria o EmailService
    }
}
