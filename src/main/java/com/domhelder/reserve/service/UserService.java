package com.domhelder.reserve.service;

import com.domhelder.reserve.dto.UserDTO;
import com.domhelder.reserve.entity.User;
import com.domhelder.reserve.repository.UserRepository;

import java.util.UUID;
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
        user.setUserName(userDTO.getUserName());
        user.setRole(userDTO.getRole());
        user.setEmail(userDTO.getEmail());
        user.setValidUser(true);
        return userRepository.save(user);
    }

    // Update
    public User updateUser(UUID uuid, UserDTO userDTO) {
        User user = userRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o id: " + uuid));
        
        user.setUserName(userDTO.getUserName());
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
