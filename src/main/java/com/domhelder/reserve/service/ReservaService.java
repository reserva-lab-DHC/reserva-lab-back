package com.domhelder.reserve.service;

import com.domhelder.reserve.dto.ReservaDTO;
import com.domhelder.reserve.entity.Reserva;
import com.domhelder.reserve.entity.Sala;
import com.domhelder.reserve.entity.StatusReserva;
import com.domhelder.reserve.entity.User;
import com.domhelder.reserve.repository.ReservaRepository;
import com.domhelder.reserve.repository.SalaRepository;
import com.domhelder.reserve.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private UserRepository userRepository;

    private SalaRepository salaRepository;

    public ReservaService(ReservaRepository reservaRepository, UserRepository userRepository, SalaRepository salaRepository) {
        this.reservaRepository = reservaRepository;
        this.userRepository = userRepository;
        this.salaRepository = salaRepository;
    }

    // Create 
    public Reserva createReserva(ReservaDTO reservaDTO) {
        Reserva reserva = new Reserva();

        reserva.setDataReserva(reservaDTO.getDataReserva());
        reserva.setDiasReservados(reservaDTO.getDiasReservados()); // <-- aqui mudou
        reserva.setStatus(reservaDTO.getStatus());

        // Buscar o User (solicitante) pelo ID
        User solicitante = userRepository.findById(reservaDTO.getSolicitanteId())
                .orElseThrow(() -> new EntityNotFoundException("Solicitante não encontrado"));
        reserva.setSolicitante(solicitante);

        // Buscar a Sala pelo ID
        Sala sala = salaRepository.findById(reservaDTO.getSalaReservadaId())
                .orElseThrow(() -> new EntityNotFoundException("Sala não encontrada"));
        reserva.setSalaReservada(sala);

        // Setar campos adicionais
        reserva.setDisciplinaRelacionada(reservaDTO.getDisciplinaRelacionada());
        reserva.setMotivoReserva(reservaDTO.getMotivoReserva());
        reserva.setDataInicio(reservaDTO.getDataInicio());
        reserva.setDataConclusao(reservaDTO.getDataConclusao());

        // Se o ID vier no DTO (para atualização), setar também
        if (reservaDTO.getId() != null) {
            reserva.setId(reservaDTO.getId());
        }

        return reservaRepository.save(reserva);
    }
    // Read
    public List<Reserva> listReservaBySala(UUID uuid, StatusReserva status){
        if (StatusReserva.ALL.equals(status)){
            return reservaRepository.findBySalaReservada_Id(uuid);
        }
        else {
            return reservaRepository.findBySalaReservada_IdAndStatus(uuid,status);
        }
    }

    public List<Reserva> listReservaByStatus(StatusReserva status){
        if (StatusReserva.ALL.equals(status)){
            return reservaRepository.findAll();
        }
        else {
            return reservaRepository.findByStatus(status);
        }
    }

    // Update
    public Reserva editarReserva(UUID uuid, ReservaDTO reservaDTO) {
        Reserva reserva = reservaRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Reserva não encontrada"));

        // Atualizar os campos da reserva
        reserva.setDataReserva(reservaDTO.getDataReserva());
        reserva.setDiasReservados(reservaDTO.getDiasReservados()); // << mudou aqui
        reserva.setStatus(reservaDTO.getStatus());

        // Buscar o User (solicitante) pelo ID
        User solicitante = userRepository.findById(reservaDTO.getSolicitanteId())
                .orElseThrow(() -> new EntityNotFoundException("Solicitante não encontrado"));
        reserva.setSolicitante(solicitante);

        // Buscar a Sala pelo ID
        Sala sala = salaRepository.findById(reservaDTO.getSalaReservadaId())
                .orElseThrow(() -> new EntityNotFoundException("Sala não encontrada"));
        reserva.setSalaReservada(sala);

        // Setar campos adicionais
        reserva.setDisciplinaRelacionada(reservaDTO.getDisciplinaRelacionada());
        reserva.setMotivoReserva(reservaDTO.getMotivoReserva());
        reserva.setDataInicio(reservaDTO.getDataInicio());
        reserva.setDataConclusao(reservaDTO.getDataConclusao());

        return reservaRepository.save(reserva);
    }

    // Delete
    public void deleteReserva(UUID uuid){
        Reserva reserva = reservaRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Reserva não encontrada"));
        reservaRepository.delete(reserva);

    }

}
