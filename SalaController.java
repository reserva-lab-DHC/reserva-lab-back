package com.domhelder.reserve.controller;

import com.domhelder.reserve.dto.SalaDTO;
import com.domhelder.reserve.entity.Sala;
import com.domhelder.reserve.service.SalaService;
import com.domhelder.reserve.utils.UUIDutils;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/sala")
public class SalaController {
    private SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    
    @PostMapping()
    public ResponseEntity<Sala> criarSala(@RequestBody SalaDTO salaDTO){
        Sala createdSala = salaService.createSala(salaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSala);
    }
   
    @GetMapping("/{uuidString}")
    public ResponseEntity<Sala> getSalaById(@PathVariable String uuidString) {
        try {
            UUID uuid = UUIDutils.convertStringtoUUID(uuidString);
            Sala sala = salaService.getSalaById(uuid);
            return ResponseEntity.ok(sala);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null); // Retorna HTTP 404 se a sala não for encontrada
        }
    }

    @GetMapping()
    public ResponseEntity<?> ListAllSalas(){
        try {
            List<Sala> salaList = salaService.getAllSalas();
            return ResponseEntity.status(HttpStatus.OK).body(salaList); // Retorna HTTP 200 OK com a lista de salas
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao listar salas: " + e.getMessage()); // HTTP 500
        }
    }

    public String requestMethodName(@RequestParam String param) {
        return new String();
    }

    @PutMapping("/{uuidString}")
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

    @DeleteMapping("/{uuidString}")
    public ResponseEntity<String> deleteSala(@PathVariable String uuidString) {
        try {
            UUID uuid = UUIDutils.convertStringtoUUID(uuidString);
            salaService.deleteSala(uuid);
            return ResponseEntity.ok("Sala deletada com sucesso");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erro: Sala não encontrada para o UUID: " + uuidString); // HTTP 404
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar sala: " + e.getMessage()); // HTTP 500
        }
    }
    



}
