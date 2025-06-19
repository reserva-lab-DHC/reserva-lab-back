package com.domhelder.reserve.repository;

import com.domhelder.reserve.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SalaRepository extends JpaRepository<Sala, UUID> {
    boolean existsByNomeSala(String nomeSala);
}
