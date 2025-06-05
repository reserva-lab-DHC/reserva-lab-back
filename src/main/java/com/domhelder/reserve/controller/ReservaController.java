package com.domhelder.reserve.controller;

import com.domhelder.reserve.dto.ReservaDTO;
import com.domhelder.reserve.entity.Reserva;
import com.domhelder.reserve.entity.StatusReserva;
import com.domhelder.reserve.service.ReservaService;
import com.domhelder.reserve.utils.UUIDutils;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/reserva")
public class ReservaController {
    private ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    @RequestMapping("/criar")
    public ResponseEntity<Reserva> criarReserva(@RequestBody ReservaDTO reservaDTO) {
        Reserva reservaCriada = reservaService.createReserva(reservaDTO);
        return new ResponseEntity<>(reservaCriada, HttpStatus.CREATED);
    }

    @GetMapping
    @RequestMapping("/{uuid}/{status}")
    public ResponseEntity<List<Reserva>> listReservasBySala(
            @PathVariable UUID uuid,
            @PathVariable StatusReserva status){
        List<Reserva> reservaList = reservaService.listReservaBySala(uuid, status);
        return ResponseEntity.status(HttpStatus.OK).body(reservaList);
    }

    @PutMapping
    @RequestMapping("/editar/{uuidString}")
    public ResponseEntity<?> editarReserva(
            @PathVariable String uuidString, 
            @RequestBody ReservaDTO reservaDTO) {
       
        try {
        // Converte a string UUID para um objeto UUID
        UUID uuid = UUIDutils.convertStringtoUUID(uuidString);
        // Chama o serviço para editar a reserva
        Reserva reservaAtualizada = reservaService.editarReserva(uuid, reservaDTO);
        return ResponseEntity.ok(reservaAtualizada); // HTTP 200 OK
    } catch (EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reserva não encontrada"); // HTTP 404
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao editar reserva"); // HTTP 500
    }
 }

    @DeleteMapping
    @RequestMapping("/deletar/{uuidString}")
    public ResponseEntity<?> deletarReserva(@PathVariable String uuidString) {
        try {
            UUID uuid = UUIDutils.convertStringtoUUID(uuidString);
            reservaService.deleteReserva(uuid);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // HTTP 204 No Content
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reserva não encontrada"); // HTTP 404
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar reserva"); // HTTP 500
        }
    }
    
}
