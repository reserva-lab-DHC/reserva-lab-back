package com.domhelder.reserve.service;

import com.domhelder.reserve.dto.SalaDTO;
import com.domhelder.reserve.entity.Sala;
import com.domhelder.reserve.repository.SalaRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class SalaService {
    private final SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    public Sala createSala(SalaDTO salaDTO){
        Sala sala = new Sala();
        sala.setNomeSala(salaDTO.getNomeSala());
        sala.setAndar(salaDTO.getAndar());
        sala.setPredio(salaDTO.getPredio());
        return salaRepository.save(sala);
    }

    public Sala editSala(UUID uuid, SalaDTO salaDTO) {
        Sala salaEditada = salaRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Sala não encontrada com o UUID: " + uuid));
        
        salaEditada.setNomeSala(salaDTO.getNomeSala());
        salaEditada.setAndar(salaDTO.getAndar());
        salaEditada.setPredio(salaDTO.getPredio());
        
        return salaRepository.save(salaEditada);
   }


}
