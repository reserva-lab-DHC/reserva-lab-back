package com.domhelder.reserve.service;

import com.domhelder.reserve.entity.Reserva;
import com.domhelder.reserve.repository.ReservaRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }
    public Reserva CreateReserva(Reserva reserva){
        return reservaRepository.save(reserva);
    }
}
