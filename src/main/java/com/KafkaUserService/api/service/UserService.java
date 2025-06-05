package com.KafkaUserService.api.service;

import com.KafkaUserService.api.models.User;
import com.KafkaUserService.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listarUsuarios() {
        return userRepository.findAll();
    }

    public User salvarUsuario(User usuario) {
        return userRepository.save(usuario);
    }
}
