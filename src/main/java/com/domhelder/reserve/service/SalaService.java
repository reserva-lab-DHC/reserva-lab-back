package com.domhelder.reserve.service;

import com.domhelder.reserve.dto.SalaDTO;
import com.domhelder.reserve.entity.Sala;
import com.domhelder.reserve.exception.DuplicatedResourceException;
import com.domhelder.reserve.repository.SalaRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class SalaService {
    private final SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

        public List<Sala> getAllSalas() {
        return salaRepository.findAll();
    }
    
    public Sala createSala(SalaDTO salaDTO) throws Exception {
        if (salaRepository.existsByNomeSala(salaDTO.getNomeSala())) {
            throw new DuplicatedResourceException("Sala já cadastrada: " + salaDTO.getNomeSala());
        }
        Sala sala = new Sala();
        sala.setNomeSala(salaDTO.getNomeSala());
        sala.setAndar(salaDTO.getAndar());
        sala.setPredio(salaDTO.getPredio());
        sala.setImage(salaDTO.getImage());
        return salaRepository.save(sala);
    }

    public Sala editSala(UUID uuid, SalaDTO salaDTO) {
        Sala salaEditada = salaRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Sala não encontrada com o UUID: " + uuid));
        
        salaEditada.setNomeSala(salaDTO.getNomeSala());
        salaEditada.setAndar(salaDTO.getAndar());
        salaEditada.setPredio(salaDTO.getPredio());
        salaEditada.setImage(salaDTO.getImage());
        
        return salaRepository.save(salaEditada);
   }
   
    public Sala getSalaById(UUID uuid) {
        return salaRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Sala não encontrada com o UUID: " + uuid));
    }
    public void deleteSala(UUID uuid) {
        Sala sala = salaRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Sala não encontrada com o UUID: " + uuid));
        salaRepository.delete(sala);
    }


}
