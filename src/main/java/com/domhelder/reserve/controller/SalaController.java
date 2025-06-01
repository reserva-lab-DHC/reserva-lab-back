package com.domhelder.reserve.controller;

import com.domhelder.reserve.dto.SalaDTO;
import com.domhelder.reserve.dto.UserDTO;
import com.domhelder.reserve.entity.Sala;
import com.domhelder.reserve.entity.User;
import com.domhelder.reserve.service.SalaService;
import com.domhelder.reserve.service.UserService;
import com.domhelder.reserve.utils.UUIDutils;

import jakarta.persistence.EntityNotFoundException;

import java.util.UUID;

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

    @PutMapping("/editar/{uuidString}")
    public ResponseEntity<?> editarSala(
        @PathVariable String uuidString,
        @RequestBody SalaDTO salaDTO) {
    
    try {
        // Converte a string UUID para um objeto UUID
        UUID uuid = UUIDutils.convertStringtoUUID(uuidString);
        // Chama o serviço para editar a sala
        Sala updatedSala = salaService.editSala(uuid, salaDTO);
        return ResponseEntity.ok(updatedSala); // Retorna HTTP 200 OK com a sala atualizada
    } catch (EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Erro: Sala não encontrada para o UUID: " + uuidString); // HTTP 404
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro ao editar sala: " + e.getMessage()); // HTTP 500
    }
}

    public String requestMethodName(@RequestParam String param) {
        return new String();
    }
    

//    @GetMapping
//    public ResponseEntity<User> getUserById(@RequestMapping )


}
