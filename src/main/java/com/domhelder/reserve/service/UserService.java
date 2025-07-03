package com.domhelder.reserve.service;

import com.domhelder.reserve.dto.UserDTO;
import com.domhelder.reserve.entity.User;
import com.domhelder.reserve.repository.UserRepository;

import java.util.UUID;

import com.domhelder.reserve.utils.CriptografiaSenha;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create
    public User createUser(UserDTO userDTO){
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setRole(userDTO.getRole());
        user.setEmail(userDTO.getEmail());
        user.setValidUser(true);
        user.setPassword(CriptografiaSenha.criptografarSenha(userDTO.getRawPassword()));
        return userRepository.save(user);
    }

    // Update
    public User updateUser(UUID uuid, UserDTO userDTO) {
        User user = userRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o id: " + uuid));
        
        user.setUsername(userDTO.getUsername());
        user.setRole(userDTO.getRole());
        user.setEmail(userDTO.getEmail());
        
        return userRepository.save(user);
    }

    // Read
    public User getUserById(UUID uuid) {
        return userRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o id: " + uuid));
    }

    // Delete
    public void deleteUser(UUID uuid) {
        User user = userRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o id: " + uuid));
        userRepository.delete(user);
    }
    

    



}
