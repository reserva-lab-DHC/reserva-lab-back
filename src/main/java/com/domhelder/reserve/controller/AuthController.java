package com.domhelder.reserve.controller;


import com.domhelder.reserve.dto.AuthDTO;
import com.domhelder.reserve.entity.User;
import com.domhelder.reserve.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/verify")
    public ResponseEntity<User> verificarSenha(@RequestBody AuthDTO request) {
        User user = authService.verificarSenha(request.getUsername(), request.getRawPassword());

        if (user.isValidUser()) {
        return ResponseEntity.ok(user);
    } else {
        return ResponseEntity.status(401).body(null);
    }
}
}
