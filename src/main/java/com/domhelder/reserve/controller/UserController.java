package com.domhelder.reserve.controller;

import com.domhelder.reserve.dto.UserDTO;
import com.domhelder.reserve.entity.User;
import com.domhelder.reserve.service.UserService;
import com.domhelder.reserve.utils.UUIDutils;

import jakarta.persistence.EntityNotFoundException;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<User> criarUser(@RequestBody UserDTO userDTO) {
        try {
            User createdUser = userService.createUser(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser); // HTTP 201 Created
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // HTTP 500 se ocorrer um erro
        }
    }

    @GetMapping("/{uuidString}")
    public ResponseEntity<User> getUserById(@PathVariable String uuidString) {
        try {
            // Converte a string UUID para um objeto UUID
            UUID uuid = UUIDutils.convertStringtoUUID(uuidString);
            User user = userService.getUserById(uuid);
            return ResponseEntity.ok(user); // HTTP 200 OK
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null); // HTTP 404 se o usuário não for encontrado
        }
    }

    @PutMapping("/{uuidString}")
    public ResponseEntity<?> editarUser(
            @PathVariable String uuidString,
            @RequestBody UserDTO userDTO) {
        try {
            // Converte a string UUID para um objeto UUID
            UUID uuid = UUIDutils.convertStringtoUUID(uuidString);

            User updatedUser = userService.updateUser(uuid, userDTO);
            return ResponseEntity.ok(updatedUser); // HTTP 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao editar usuário: " + e.getMessage()); // HTTP 500
        }
    }

    @DeleteMapping("/{uuidString}")
    public ResponseEntity<?> deletarUser(@PathVariable String uuidString) {
        try {
            // Converte a string UUID para um objeto UUID
            UUID uuid = UUIDutils.convertStringtoUUID(uuidString);
            userService.deleteUser(uuid);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // HTTP 204 No Content
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário não encontrado para o UUID: " + uuidString); // HTTP 404
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar usuário: " + e.getMessage()); // HTTP 500
        }
    }
}
