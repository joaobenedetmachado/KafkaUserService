package com.KafkaUserService.api.controller;


import com.KafkaUserService.api.models.User;
import com.KafkaUserService.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> salvarUsuario(@RequestBody User usuario) {
        User salvo = userService.salvarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> listarUsuarios() {
        return ResponseEntity.ok(userService.listarUsuarios());
    }

    @GetMapping("/user/confirm")
    public ResponseEntity<String> confirmarEmail(@RequestParam String email) {
        Optional<User> optionalUser = userService.buscarPorEmail(email);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setAtivo(true);
            userService.salvarUsuario(user);
            return ResponseEntity.ok("conta confirmada");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("usuario não encontrado");
        }
    }

}
