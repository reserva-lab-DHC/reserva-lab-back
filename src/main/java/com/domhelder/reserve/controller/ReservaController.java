package com.domhelder.reserve.controller;

import com.domhelder.reserve.dto.ReservaDTO;
import com.domhelder.reserve.dto.SalaDTO;
import com.domhelder.reserve.entity.Reserva;
import com.domhelder.reserve.entity.Sala;
import com.domhelder.reserve.service.ReservaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
