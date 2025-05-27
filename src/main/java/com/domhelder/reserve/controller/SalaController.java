package com.domhelder.reserve.controller;

import com.domhelder.reserve.dto.SalaDTO;
import com.domhelder.reserve.dto.UserDTO;
import com.domhelder.reserve.entity.Sala;
import com.domhelder.reserve.entity.User;
import com.domhelder.reserve.service.SalaService;
import com.domhelder.reserve.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sala")
public class SalaController {
    private SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @PostMapping
    public ResponseEntity<Sala> criarSala(@RequestBody SalaDTO salaDTO){
        Sala createdSala = salaService.createSala(salaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSala);
    }

//    @GetMapping
//    public ResponseEntity<User> getUserById(@RequestMapping )


}
