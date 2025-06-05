package com.KafkaUserService.api.Kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.KafkaUserService.api.models.User;

@Component
//criamos o userProducer
public class UserProducer {

    // criamos um topico da mensagem que nesse caso é para quando o user é criado
    private static final String TOPIC = "user-criado";

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    //enviamos para a o "quadro de anotações"
    public void enviarParaKafka(User user) {
        kafkaTemplate.send(TOPIC, user);
    }
}
