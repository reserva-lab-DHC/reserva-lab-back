package com.domhelder.reserve.controller;

import com.domhelder.reserve.dto.UserDTO;
import com.domhelder.reserve.entity.User;
import com.domhelder.reserve.service.UserService;
import com.domhelder.reserve.utils.UUIDutils;

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

    @PostMapping
    public ResponseEntity<User> criarReserva(@RequestBody UserDTO userDTO){
       User createdUser = userService.createUser(userDTO);
       return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

//    @GetMapping
//    public ResponseEntity<User> getUserById(@RequestMapping )

    @PutMapping
    @RequestMapping("/editar/{uuidString}")
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
}
