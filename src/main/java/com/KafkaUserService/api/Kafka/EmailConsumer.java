package com.KafkaUserService.api.Kafka;

import com.KafkaUserService.api.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.json.JSONObject;

public class EmailConsumer {

    @Autowired
    EmailService emailService;

    @KafkaListener(topics = "user-criado", groupId = "email-service")
    public void processarMensagem(String emailJson) {
        JSONObject obj = new JSONObject(emailJson);
        String email = obj.getString("email");
        String nome = obj.getString("nome");

        emailService.enviarEmailConfirmacao(email, nome);
    }

}
