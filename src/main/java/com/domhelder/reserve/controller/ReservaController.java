package com.domhelder.reserve.controller;

import com.domhelder.reserve.dto.ReservaDTO;
import com.domhelder.reserve.dto.SalaDTO;
import com.domhelder.reserve.entity.Reserva;
import com.domhelder.reserve.entity.Sala;
import com.domhelder.reserve.entity.StatusReserva;
import com.domhelder.reserve.service.ReservaService;
import org.apache.coyote.Response;
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
}
