package com.domhelder.reserve.service;

import com.domhelder.reserve.entity.User;
import com.domhelder.reserve.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthService {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User verificarSenha(String username, String senhaDigitada) {
        User usuario = userRepository.getUserByUserName(username);
        if (usuario == null) {
            return null;
        }
        boolean matchUser = encoder.matches(senhaDigitada, usuario.getPassword());
        if (matchUser){
            return usuario;
        }
        return null;
    }
}
