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

    public User createUser(UserDTO userDTO){
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setRole(userDTO.getRole());
        user.setEmail(userDTO.getEmail());
        user.setValidUser(true);
        return userRepository.save(user);
    }

    public User updateUser(UUID uuid, UserDTO userDTO) {
        User user = userRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o id: " + uuid));
        
        user.setUserName(userDTO.getUserName());
        user.setRole(userDTO.getRole());
        user.setEmail(userDTO.getEmail());
        
        return userRepository.save(user);
    }

    



}
