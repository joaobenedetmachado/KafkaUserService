package com.KafkaUserService.api.repository;

import com.KafkaUserService.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//JpaRepository, para salvar, excluir, listar e etc
public interface UserRepository extends JpaRepository<User, Integer> {
    // opcao para buscar por email
    Optional<User> findByEmail(String email);
}
