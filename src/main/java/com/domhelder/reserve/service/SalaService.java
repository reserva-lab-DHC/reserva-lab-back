package com.domhelder.reserve.service;

import com.domhelder.reserve.dto.SalaDTO;
import com.domhelder.reserve.dto.UserDTO;
import com.domhelder.reserve.entity.Sala;
import com.domhelder.reserve.entity.User;
import com.domhelder.reserve.repository.SalaRepository;
import com.domhelder.reserve.repository.UserRepository;
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


}
