package com.KafkaUserService.api.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.KafkaUserService.api.models.User;

@Component
public class UserProducer {

    private static final String TOPIC = "user-criado";

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void enviarParaKafka(User user) {
        kafkaTemplate.send(TOPIC, user);
    }
}
