package com.domhelder.reserve.controller;

import com.domhelder.reserve.dto.UserDTO;
import com.domhelder.reserve.entity.User;
import com.domhelder.reserve.service.UserService;
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


}
