package com.KafkaUserService.api.repository;

import com.KafkaUserService.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
