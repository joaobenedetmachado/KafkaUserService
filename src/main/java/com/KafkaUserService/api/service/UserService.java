package com.KafkaUserService.api.service;

import com.KafkaUserService.api.models.User;
import com.KafkaUserService.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.KafkaUserService.api.kafka.UserProducer;
import java.util.List;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProducer userProducer;

    public List<User> listarUsuarios() {
        return userRepository.findAll();
    }

    public User salvarUsuario(User usuario) {
        User usersalvo = userRepository.save(usuario);
        userProducer.enviarParaKafka(usersalvo);
        return usersalvo;
    }
}
