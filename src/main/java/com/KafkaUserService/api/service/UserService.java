package com.KafkaUserService.api.service;

import com.KafkaUserService.api.models.User;
import com.KafkaUserService.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.KafkaUserService.api.Kafka.UserProducer;
import java.util.List;
import java.util.Optional;

//aqui "linkamos" as funcoes do jpa repository para a nossa logica com o service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProducer userProducer;

    //lista os usuarios
    public List<User> listarUsuarios() {
        return userRepository.findAll();
    }

    //aqui é diferente:
    public User salvarUsuario(User usuario) {
        // colocamos ele numa variavel e a salvamos com o Repository
        User usersalvo = userRepository.save(usuario);
        // chamamos o kafka, e "salvamos" ele la
        userProducer.enviarParaKafka(usersalvo);
        return usersalvo; // retornamos o user, so pra retornar algo mesmo
    }

    public Optional<User> buscarPorEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
