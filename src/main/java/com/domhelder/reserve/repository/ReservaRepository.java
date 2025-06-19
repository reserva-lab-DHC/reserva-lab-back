package com.domhelder.reserve.repository;

import com.domhelder.reserve.entity.Reserva;
import com.domhelder.reserve.entity.StatusReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, UUID>{
    List<Reserva> findBySalaReservada_Id(UUID salaId);
    List<Reserva> findBySalaReservada_IdAndStatus(UUID salaId, StatusReserva status);
    List<Reserva> findByStatus(StatusReserva status);
}
